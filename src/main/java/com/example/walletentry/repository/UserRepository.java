package com.example.walletentry.repository;

import com.example.walletentry.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findByPhoneNumber(String phoneNumber);
}
