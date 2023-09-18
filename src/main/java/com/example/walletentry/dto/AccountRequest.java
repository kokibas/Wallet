package com.example.walletentry.dto;

import com.example.walletentry.entity.Account;

public class AccountRequest {

    private Long accountId;
    private double amount;




    public AccountRequest(Long accountId, double amount) {
        this.accountId = accountId;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }


}
