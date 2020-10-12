package com.pismo.challenge.service;

import com.pismo.challenge.entity.Account;
import com.pismo.challenge.exceptions.NotFoundAccountExeption;
import com.pismo.challenge.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account newAccount(Account newAccount) {
        return accountRepository.save(newAccount);
    }


    public Account findById(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new NotFoundAccountExeption(id));
    }
}
