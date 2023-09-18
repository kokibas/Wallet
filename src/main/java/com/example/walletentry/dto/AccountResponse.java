package com.example.walletentry.dto;

public class AccountResponse {
    private boolean ok;
    public AccountResponse() {
    }



    public AccountResponse(boolean ok) {
        this.ok = ok;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }
}
