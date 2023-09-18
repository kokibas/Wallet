package com.example.walletentry.repository;

import com.example.walletentry.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<Account,Long> {
   public Account findByAccountId(Long accountId);
}
