package com.example.walletentry.service;

import com.example.walletentry.entity.Account;
import com.example.walletentry.entity.Transaction;
import com.example.walletentry.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class TransactionGetForAccountService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionGetForAccountService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    @Transactional
    public List<Transaction> getTransactionsForAccount(Account account) {
        return transactionRepository.findBySenderAccount(account);
    }
}
