package com.example.expense.service;

import com.example.expense.entity.BankDetails;
import com.example.expense.repository.BankDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankDetailsService {

    private BankDetailsRepository bankDetailsRepository;

    private static final Logger log = LoggerFactory.getLogger(com.example.expense.service.BankDetailsService.class);

    @Autowired
    public BankDetailsService(BankDetailsRepository repository) {
        this.bankDetailsRepository = repository;
    }

    public int addNewBankDetails(BankDetails bankDetails) {
        log.info("storing bank details - " + bankDetails.toString());
        bankDetails =  this.bankDetailsRepository.save(bankDetails);
        return bankDetails.getBankId();
    }

    public Optional<BankDetails> getBankById(int id) {
        return bankDetailsRepository.findById(id);
    }

    public void updateBankDetails(BankDetails bankDetails) {
        log.info("updating bank details - " + bankDetails.toString());
        this.bankDetailsRepository.save(bankDetails);
    }
}
