package com.example.walletentry.service;

import com.example.walletentry.entity.User;
import com.example.walletentry.repository.UserRepository;
import com.example.walletentry.validator.ValidPhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final ValidPhoneNumber validPhoneNumber;
    private final VerificationCode verificationCode;
    private final SmsService smsService;

    @Autowired
    public UserService(UserRepository userRepository, ValidPhoneNumber validPhoneNumber, VerificationCode verificationCode, SmsService smsService) {
        this.userRepository = userRepository;
        this.validPhoneNumber = validPhoneNumber;
        this.verificationCode = verificationCode;
        this.smsService = smsService;
    }

    @Transactional
    public User registerUser(String phoneNumber) {
        if (!validPhoneNumber.isValidPhoneNumber(phoneNumber))
            throw new IllegalStateException("format incorrect");
        User user = userRepository.findByPhoneNumber(phoneNumber);
        if (user == null) {
            user = new User();
            user.setPhoneNumber(phoneNumber);
        }
        String newVerificationCode = verificationCode.generateVerificationCode();
        user.setVerificationCode(newVerificationCode);
        userRepository.save(user);
        smsService.sendSmsCode(phoneNumber, newVerificationCode);
        return user;
    }
}
