package com.example.demo.controller;

import jakarta.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.AccountDTO;
import com.example.demo.dto.TransferDTO;
import com.example.demo.entity.Account;
import com.example.demo.entity.Transaction;
import com.example.demo.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/accounts")

public class AccountController {

	@Autowired
    private  AccountService accountService;

    @PostMapping("/create")
    public Account createAccount(@Valid @RequestBody AccountDTO dto){
        return accountService.createAccount(dto);
    }

    @GetMapping("/all")
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @PostMapping("/transfer")
    public String transferMoney(@Valid @RequestBody TransferDTO dto){
        return accountService.transferMoney(dto);
    }

    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions(){
        return accountService.getAllTransactions();
    }
}
