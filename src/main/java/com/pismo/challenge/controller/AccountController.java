package com.pismo.challenge.controller;

import com.pismo.challenge.entity.Account;
import com.pismo.challenge.exceptions.NotFoundAccountExeption;
import com.pismo.challenge.repository.AccountRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    private final AccountRepository repository;

    public AccountController(AccountRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/accounts")
    Account newAccount(@RequestBody Account newAccount) {
        return repository.save(newAccount);
    }

    @GetMapping("/accounts/{id}")
    Account one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundAccountExeption(id));
    }








}
