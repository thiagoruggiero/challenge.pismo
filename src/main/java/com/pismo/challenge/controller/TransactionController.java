package com.pismo.challenge.controller;

import com.pismo.challenge.entity.Transaction;
import com.pismo.challenge.service.TransactionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transactions")
    Transaction newTransaction(@RequestBody Transaction newTransaction) throws Exception {
        return transactionService.newTransaction(newTransaction);
    }

}
