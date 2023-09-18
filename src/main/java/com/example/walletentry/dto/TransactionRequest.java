package com.example.walletentry.dto;

import java.time.LocalDateTime;

public class TransactionRequest {
    private Long receiverAccountId;
    private Long senderAccountId;
    private double amount; // Сумма транзакции
    private String transactionType; // Тип транзакции (кредит или дебет)


    public Long getReceiverAccountId() {
        return receiverAccountId;
    }

    public void setReceiverAccountId(Long receiverAccountId) {
        this.receiverAccountId = receiverAccountId;
    }

    public Long getSenderAccountId() {
        return senderAccountId;
    }

    public void setSenderAccountId(Long senderAccountId) {
        this.senderAccountId = senderAccountId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
