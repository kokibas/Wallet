package com.example.walletentry.controllers;

import com.example.walletentry.dto.UserRegistrationRequest;
import com.example.walletentry.dto.UserRegistrationResponse;
import com.example.walletentry.entity.User;
import com.example.walletentry.service.SmsService;
import com.example.walletentry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public UserRegistrationResponse registerUser(@RequestBody UserRegistrationRequest request) {
        User user = userService.registerUser(request.getPhoneNumber());

        return new UserRegistrationResponse(true);

    }
}
