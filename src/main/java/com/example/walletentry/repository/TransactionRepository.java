package com.example.walletentry.repository;

import com.example.walletentry.entity.Account;
import com.example.walletentry.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<com.example.walletentry.entity.Transaction,Long> {
    List<Transaction> findBySenderAccount(Account senderAccount);
    List<Transaction> findByReceiverAccount(Account receiverAccount);
    List<Transaction> findBySenderAccountAndTransactionDateBefore(Account senderAccount,Date date);
    List<Transaction> findByReceiverAccountAndTransactionDateBefore(Account receiverAccount,Date date);

}
