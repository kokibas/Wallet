package com.example.walletentry.controllers;

import com.example.walletentry.dto.TransactionRequest;
import com.example.walletentry.dto.TransactionResponse;
import com.example.walletentry.entity.Account;
import com.example.walletentry.entity.Transaction;
import com.example.walletentry.repository.AccountRepository;
import com.example.walletentry.roles.TransactionType;
import com.example.walletentry.service.TransactionBalanceService;
import com.example.walletentry.service.TransactionCreateService;
import com.example.walletentry.service.TransactionGetForAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    private final TransactionBalanceService transactionBalanceService;
    private final TransactionCreateService transactionCreateService;
    private final TransactionGetForAccountService transactionGetForAccountService;
    private final AccountRepository accountRepository;
    @Autowired
    public TransactionController(TransactionBalanceService transactionBalanceService,
                                 TransactionCreateService transactionCreateService,
                                 TransactionGetForAccountService transactionGetForAccountService,
                                 AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        this.transactionBalanceService = transactionBalanceService;
        this.transactionCreateService = transactionCreateService;
        this.transactionGetForAccountService = transactionGetForAccountService;
    }
    @PostMapping("/create")
    public TransactionResponse createTransaction(@RequestBody TransactionRequest transactionRequest){
        Transaction transaction = new Transaction();
        transaction.setAmount(transactionRequest.getAmount());
        transaction.setTransactionType(TransactionType.valueOf(transactionRequest.getTransactionType()));

        Account sender =  accountRepository.findByAccountId(transactionRequest.getSenderAccountId());
        Account receiver =  accountRepository.findByAccountId(transactionRequest.getReceiverAccountId());

        transaction.setSenderAccount(sender);
        transaction.setReceiverAccount(receiver);
        transactionCreateService.createTransaction(transaction);
        return new TransactionResponse(true);
    }
    @GetMapping("/balance")
    public TransactionResponse getBalanceOnDate(@RequestParam Long accountId,
                                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date date){
        Account account =  accountRepository.findByAccountId(accountId);
        double balance = transactionBalanceService.getBalanceOnDate(account,date);
        return new TransactionResponse(balance);
    }
    @GetMapping("/account/{accountId}")
    public TransactionResponse getTransactionsForAccount(@PathVariable Long accountId){
        Account account = accountRepository.findByAccountId(accountId);
        List<Transaction> transactions = transactionGetForAccountService.getTransactionsForAccount(account);
        return new TransactionResponse(transactions);
    }
}
