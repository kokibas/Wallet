package com.example.walletentry.service;

import com.example.walletentry.entity.Account;
import com.example.walletentry.entity.Transaction;
import com.example.walletentry.repository.TransactionRepository;
import com.example.walletentry.roles.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class TransactionBalanceService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionBalanceService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public double getBalanceOnDate(Account account, Date date) {
        List<Transaction> transactions = transactionRepository.findBySenderAccountAndTransactionDateBefore(account, date);
        double balance = account.getBalance();
        for (Transaction transaction : transactions) {
            TransactionType transactionType = transaction.getTransactionType();
            if (TransactionType.CREDIT.equals(transactionType)) {
                balance += transaction.getAmount();
            } else if (TransactionType.DEBIT.equals(transactionType)) {
                balance -= transaction.getAmount();
            }
        }
        return balance;
    }
}

