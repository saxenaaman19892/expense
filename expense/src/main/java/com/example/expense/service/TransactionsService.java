package com.example.expense.service;

import com.example.expense.entity.Transactions;
import com.example.expense.repository.TransactionsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionsService {

    private TransactionsRepository repository;

    @Autowired
    public TransactionsService(TransactionsRepository transactionsRepository) {
        this.repository = transactionsRepository;
    }

    @Transactional
    public int addNewTransaction(Transactions transactions) {
        transactions = this.repository.save(transactions);
        return transactions.getId();
    }

    public List<Transactions> getNewProcessedTransactions() {
        return repository.findAllByProcessed(0);
    }

    @Transactional
    public void updateTransaction(Transactions transactions) {
        this.repository.save(transactions);
    }
}
