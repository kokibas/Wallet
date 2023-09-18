package com.example.walletentry.service;

import com.example.walletentry.entity.Transaction;
import com.example.walletentry.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class TransactionCreateService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionCreateService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public void createTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

}
