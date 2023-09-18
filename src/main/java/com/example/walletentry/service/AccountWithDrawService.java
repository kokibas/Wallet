package com.example.walletentry.service;

import com.example.walletentry.entity.Account;
import com.example.walletentry.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountWithDrawService {
    private  AccountRepository accountRepository;

    @Autowired
    public AccountWithDrawService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Transactional
    public Account withdrawFromAccount(Long accountId, double amount) {
        Account account = accountRepository.findByAccountId(accountId);
        double currentBalance = account.getBalance();
        if (currentBalance >= amount) {
            account.setBalance(currentBalance - amount);
            accountRepository.save(account);
            return account;
        } else {
           throw new RuntimeException("Недостаточно средств на счете");
        }
    }
}
