package com.example.expense.service;

import com.example.expense.entity.BankDetails;
import com.example.expense.entity.Category;
import com.example.expense.entity.SubCategory;
import com.example.expense.entity.Transactions;
import com.example.expense.utility.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProcessTransactions {

    @Autowired
    private SubCategoryService subCategoryService;

    @Autowired
    private TransactionsService transactionsService;

    @Autowired
    private BankDetailsService bankDetailsService;

    private static final Logger log = LoggerFactory.getLogger(com.example.expense.service.ProcessTransactions.class);

    public void processNewTransactions() {
        Map<Integer, SubCategory> subCategoryMap = new HashMap<>();
        List<SubCategory> subCategoryList = subCategoryService.getAll();
        for (SubCategory subCategory : subCategoryList) {
            subCategoryMap.put(subCategory.getId(), subCategory);
        }
        List<Transactions> newTransactions = transactionsService.getNewProcessedTransactions();
        for (Transactions transaction : newTransactions) {
            SubCategory subCategory = subCategoryMap.get(transaction.getCategory());
            Category category = subCategory.getCategory();
            if (category.getId() == Constants.CATEGORY_INCOME) {
                log.info("Category is INCOME, bank account id = " + transaction.getFromBankAccount());
                Optional<BankDetails> bankDetailsOptional = bankDetailsService.getBankById(transaction.getFromBankAccount());
                if (bankDetailsOptional.isPresent()) {
                    BankDetails bank = bankDetailsOptional.get();
                    log.info("Bank details found, name = " + bank.getBankName());
                    bank.setBankBalance(bank.getBankBalance() + transaction.getAmount());
                    bank.setUpdatedDate(LocalDateTime.now());
                    log.info("Updating bank balance, ");
                    bankDetailsService.updateBankDetails(bank);
                    log.info("updating transaction , processed = 1");
                    transaction.setProcessed(1);
                    transactionsService.updateTransaction(transaction);
                }
            } else if (category.getId() == Constants.CATEGORY_EXPENSE || category.getId() == Constants.CATEGORY_INVESTMENT) {
                log.info("Category is EXPENSE or INVESTMENT, bank account id = " + transaction.getFromBankAccount());
                Optional<BankDetails> bankDetailsOptional = bankDetailsService.getBankById(transaction.getFromBankAccount());
                if (bankDetailsOptional.isPresent()) {
                    BankDetails bank = bankDetailsOptional.get();
                    log.info("Bank details found, name = " + bank.getBankName());
                    bank.setBankBalance(bank.getBankBalance() - transaction.getAmount());
                    bank.setUpdatedDate(LocalDateTime.now());
                    log.info("Updating bank balance, ");
                    bankDetailsService.updateBankDetails(bank);
                    log.info("updating transaction , processed = 1");
                    transaction.setProcessed(1);
                    transactionsService.updateTransaction(transaction);
                }
            } else if (category.getId() == Constants.CATEGORY_TRANSFER) {
                log.info("Category is TRANSFER, from bank = {}, to bank = {}", transaction.getFromBankAccount(), transaction.getToBankAccount());
                Optional<BankDetails> fromBankOptional = bankDetailsService.getBankById(transaction.getFromBankAccount());
                Optional<BankDetails> toBankOptional = bankDetailsService.getBankById(transaction.getToBankAccount());
                if (fromBankOptional.isPresent() && toBankOptional.isPresent()) {
                    BankDetails fromBank = fromBankOptional.get();
                    BankDetails toBank = toBankOptional.get();
                    log.info("from bank name = {},  to bank name = {}", fromBank.getBankName(), toBank.getBankName());
                    fromBank.setBankBalance(fromBank.getBankBalance() - transaction.getAmount());
                    toBank.setBankBalance(toBank.getBankBalance() + transaction.getAmount());
                    log.info("updating from and to bank details");
                    bankDetailsService.updateBankDetails(fromBank);
                    bankDetailsService.updateBankDetails(toBank);
                    log.info("updating transaction , processed = 1");
                    transaction.setProcessed(1);
                    transactionsService.updateTransaction(transaction);
                }
            }
        }
    }
}
