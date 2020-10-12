package com.pismo.challenge.controller;

import com.pismo.challenge.entity.Account;
import com.pismo.challenge.exceptions.NotFoundAccountExeption;
import com.pismo.challenge.service.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping("/accounts")
    Account newAccount(@RequestBody Account newAccount) {
        return service.newAccount(newAccount);
    }

    @GetMapping("/accounts/{id}")
    Account one(@PathVariable Long id) {
        return service.findById(id);
    }








}
