package com.example.expense.service;

import com.example.expense.entity.BankDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {

    private BankDetailsService bankDetailsService;

    @Autowired
    public MainService (BankDetailsService service) {
        this.bankDetailsService = service;
    }


    public int addNewBankDetails(BankDetails bankDetails) {
        return this.bankDetailsService.addNewBankDetails(bankDetails);
    }
}
