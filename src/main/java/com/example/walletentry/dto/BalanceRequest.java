package com.example.walletentry.dto;

import java.util.Date;

public class BalanceRequest {
    private Long accountId;
    private Date date;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
