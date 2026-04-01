package com.example.expense.service;

import com.example.expense.entity.BankDetails;
import com.example.expense.repository.BankDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankDetailsService {

    private BankDetailsRepository bankDetailsRepository;

    @Autowired
    public BankDetailsService(BankDetailsRepository repository) {
        this.bankDetailsRepository = repository;
    }

    public int addNewBankDetails(BankDetails bankDetails) {
        bankDetails =  this.bankDetailsRepository.save(bankDetails);
        return bankDetails.getBankId();
    }
}
