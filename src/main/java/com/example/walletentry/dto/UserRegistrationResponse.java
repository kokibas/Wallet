package com.example.walletentry.dto;

public class UserRegistrationResponse {
  private boolean ok;

    public UserRegistrationResponse() {
    }

    public UserRegistrationResponse(boolean ok) {
        this.ok = ok;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }
}
