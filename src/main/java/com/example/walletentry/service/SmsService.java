package com.example.walletentry.service;

import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsService {
    private final String twilioPhoneNumber;

    public SmsService(@Value("${twilio.phone.number}") String twilioPhoneNumber) {
        this.twilioPhoneNumber = twilioPhoneNumber;
    }

    public void sendSmsCode(String phoneNumber, String code) {
        try {
            Message.creator(
                    new com.twilio.type.PhoneNumber(phoneNumber),
                    new com.twilio.type.PhoneNumber(twilioPhoneNumber),
                    code
            ).create();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
