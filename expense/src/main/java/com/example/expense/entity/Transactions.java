package com.example.expense.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transactions {

    @Column(name = "transaction_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "amount")
    private int amount;

    @Column(name = "category")
    private int category;

    @Column(name = "comments")
    private String comments;

    @Column(name = "insert_date")
    private Date insertDate;

    @Column(name = "from_bank_account")
    private int fromBankAccount;

    @Column(name = "to_bank_account")
    private int toBankAccount;

    @Column(name = "processed")
    private int processed;

    @Column(name = "update_date")
    private Date updateDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public int getFromBankAccount() {
        return fromBankAccount;
    }

    public void setFromBankAccount(int fromBankAccount) {
        this.fromBankAccount = fromBankAccount;
    }

    public int getToBankAccount() {
        return toBankAccount;
    }

    public void setToBankAccount(int toBankAccount) {
        this.toBankAccount = toBankAccount;
    }

    public int getProcessed() {
        return processed;
    }

    public void setProcessed(int processed) {
        this.processed = processed;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
