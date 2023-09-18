package com.example.walletentry.controllers;

import com.example.walletentry.dto.AuthRequest;
import com.example.walletentry.dto.AuthResponse;
import com.example.walletentry.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/auth")
    public AuthResponse authUser(@RequestBody AuthRequest request){
        String isAuth = authService.authenticateUser(request.getPhoneNumber(), request.getCode());
        if (isAuth != null) {
            return new AuthResponse(isAuth);
        } else {
            return null;
        }

    }
}
