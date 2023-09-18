package com.example.walletentry.controllers;

import com.example.walletentry.dto.AccountRequest;
import com.example.walletentry.dto.AccountResponse;
import com.example.walletentry.entity.Account;
import com.example.walletentry.service.AccountTopUpService;
import com.example.walletentry.service.AccountWithDrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    private AccountTopUpService accountTopUpService;
    private AccountWithDrawService accountWithDrawService;
    @Autowired
    public AccountController(AccountTopUpService accountTopUpService, AccountWithDrawService accountWithDrawService) {
        this.accountTopUpService = accountTopUpService;
        this.accountWithDrawService = accountWithDrawService;
    }
    @PostMapping("/top-up")
    public AccountResponse topUpAccount(@RequestBody AccountRequest accountRequest){
        Account account = accountTopUpService.topUpAccount(accountRequest.getAccountId(),accountRequest.getAmount());
        return new AccountResponse(true);
    }
    @PostMapping("/withdraw")
    public AccountResponse withdrawAccount(@RequestBody AccountRequest accountRequest){
        Account account = accountWithDrawService.withdrawFromAccount(accountRequest.getAccountId(),accountRequest.getAmount());
        return new AccountResponse(true);
    }

}
