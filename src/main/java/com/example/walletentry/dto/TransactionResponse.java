package com.example.walletentry.dto;

import com.example.walletentry.entity.Transaction;

import java.util.List;

public class TransactionResponse {
    private boolean ok;
    private double balance;
    private List<Transaction> transactionList;

    public TransactionResponse(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public TransactionResponse(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public TransactionResponse(boolean ok) {
        this.ok = ok;
    }
    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }
}
