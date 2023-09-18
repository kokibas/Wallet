package com.example.walletentry.service;

import com.example.walletentry.entity.Account;
import com.example.walletentry.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.security.auth.login.AccountException;
import java.util.List;

@Service
public class AccountTopUpService {
    private  AccountRepository accountRepository;

    @Autowired
    public AccountTopUpService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public Account topUpAccount(Long accountId, double amount) {
       Account accounts = accountRepository.findByAccountId(accountId);
        if (accounts != null){
            double currentBalance = accounts.getBalance();
            accounts.setBalance(currentBalance + amount);
            accountRepository.save(accounts);
            return accounts;
        }
       else {
            throw new RuntimeException("not found");
        }
    }




}
