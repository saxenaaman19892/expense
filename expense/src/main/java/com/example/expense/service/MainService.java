package com.example.expense.service;

import com.example.expense.entity.BankDetails;
import com.example.expense.entity.Category;
import com.example.expense.entity.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class MainService {

    private BankDetailsService bankDetailsService;

    private TransactionsService transactionsService;

    private CategoryService categoryService;

    @Autowired
    public MainService (BankDetailsService service, TransactionsService transactService,
                        CategoryService catService) {
        this.transactionsService = transactService;
        this.bankDetailsService = service;
        this.categoryService = catService;
    }


    public int addNewBankDetails(BankDetails bankDetails) {
        bankDetails.setUpdatedDate(LocalDateTime.now());
        return this.bankDetailsService.addNewBankDetails(bankDetails);
    }

    public int addNewTransaction(Transactions transactions) {
        transactions.setInsertDate(new Date());
        transactions.setUpdateDate(new Date());
        transactions.setProcessed(0);
        return this.transactionsService.addNewTransaction(transactions);
    }

    public int addNewCategory(Category category) {
        return this.categoryService.saveCategory(category);
    }
}
