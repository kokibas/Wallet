package com.example.walletentry.entity;

import com.example.walletentry.roles.TransactionType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private LocalDateTime transactionDate;


    @ManyToOne
    @JoinColumn(name = "sender_account_id",referencedColumnName = "id")
    private Account senderAccount;

    @ManyToOne
    @JoinColumn(name = "receiver_account_id",referencedColumnName = "id")
    private Account receiverAccount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Account getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(Account senderAccount) {
        this.senderAccount = senderAccount;
    }

    public Account getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(Account receiverAccount) {
        this.receiverAccount = receiverAccount;
    }
}
