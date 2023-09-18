package com.example.walletentry.service;

import com.example.walletentry.config.JwtConf;
import com.example.walletentry.dto.AuthResponse;
import com.example.walletentry.entity.User;
import com.example.walletentry.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private UserRepository userRepository;
    private JwtConf jwt;
    @Autowired
    public AuthService(UserRepository userRepository, JwtConf jwt) {
        this.userRepository = userRepository;
        this.jwt = jwt;
    }


    public String authenticateUser(String phoneNumber, String code){
        User user = userRepository.findByPhoneNumber(phoneNumber);
        if (user != null && user.getVerificationCode().equals(code)){
            String jwtToken = jwt.generateToken(user);
            return jwtToken;
        }else
            return null;
    }
}
