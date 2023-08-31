package com.example.walletentry.service;

import org.springframework.stereotype.Component;

import java.util.Random;
@Component
public class VerificationCode {

    public String  generateVerificationCode() {
        Random random = new Random();
        int code = 1000 + random.nextInt(9000);
        return String.valueOf(code);
    }
}
