package com.pismo.challenge.controller;

import com.pismo.challenge.entity.Account;
import com.pismo.challenge.entity.Transaction;
import com.pismo.challenge.exceptions.NotFoundAccountExeption;
import com.pismo.challenge.repository.AccountRepository;
import com.pismo.challenge.repository.TransactionRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import static com.pismo.challenge.enums.OperationsTypesEnum.PAGAMENTO;

@RestController
public class TransactionController {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionController(TransactionRepository repository, AccountRepository accountRepository) {
        this.transactionRepository = repository;
        this.accountRepository = accountRepository;
    }

    @PostMapping("/transactions")
    Transaction newTransaction(@RequestBody Transaction newTransaction) {
        Account account = accountRepository.findById(newTransaction.getAccountID()).orElseThrow(() -> new NotFoundAccountExeption(newTransaction.getAccountID()));
        newTransaction.setAccount(account);
        return saveTransaction(newTransaction);
    }

    private Transaction saveTransaction(Transaction newTransaction) {
        if (newTransaction.getOperationType() != PAGAMENTO ){
            newTransaction.setAmount(newTransaction.getAmount() * -1);
        }
        newTransaction.setEventDate(new Date());
        return transactionRepository.save(newTransaction);
    }
}
