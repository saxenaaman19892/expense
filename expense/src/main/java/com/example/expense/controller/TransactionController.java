package com.example.expense.controller;

import com.example.expense.entity.Transactions;
import com.example.expense.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final MainService mainService;

    @Autowired
    public TransactionController(MainService service) {
        this.mainService = service;
    }

    @PostMapping("/add-new-transaction")
    public ResponseEntity<String> addNewTransaction(@RequestBody Transactions transactions) {
        int id = this.mainService.addNewTransaction(transactions);
        return ResponseEntity.status(HttpStatus.CREATED).body("Added new Transaction with ID = " + id);
    }
}
