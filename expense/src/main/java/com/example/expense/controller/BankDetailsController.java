package com.example.expense.controller;

import com.example.expense.entity.BankDetails;
import com.example.expense.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank-details")
public class BankDetailsController {

    private MainService mainService;

    @Autowired
    public BankDetailsController(MainService service) {
        this.mainService = service;
    }

    @PostMapping("/add-new")
    public ResponseEntity<String> addNewBankDetails(@RequestBody BankDetails bankDetails) {
        int id = this.mainService.addNewBankDetails(bankDetails);
        return ResponseEntity.ok("Added new Bank Details with id = " + id);
    }
}
