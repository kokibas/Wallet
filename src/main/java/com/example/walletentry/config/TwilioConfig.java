package com.example.walletentry.config;

import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class TwilioConfig {
    @Value("${twilio.account.sid}")
    private String accountSid;
    @Value("${twilio.auth.token}")
    private String authToken;
    @Bean
    public void initTwilio(){
        Twilio.init(accountSid,authToken);
    }
}
