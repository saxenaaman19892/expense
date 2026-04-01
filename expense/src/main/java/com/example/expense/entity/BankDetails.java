package com.example.expense.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "bank_details")
public class BankDetails {

    @Column(name = "bank_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bankId;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "bank_balance")
    private int bankBalance;

    @Column(name = "updated_date")
    private Date updatedDate;

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(int bankBalance) {
        this.bankBalance = bankBalance;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
