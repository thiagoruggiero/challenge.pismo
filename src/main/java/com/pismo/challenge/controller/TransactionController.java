package com.pismo.challenge.controller;

import com.pismo.challenge.entity.Transaction;
import com.pismo.challenge.repository.TransactionRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import static com.pismo.challenge.enums.OperationsTypesEnum.PAGAMENTO;

@RestController
public class TransactionController {

    private final TransactionRepository repository;

    public TransactionController(TransactionRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/transactions")
    Transaction newTransaction(@RequestBody Transaction newTransaction) {
        if (newTransaction.getOperationType() != PAGAMENTO ){
            newTransaction.setAmount(newTransaction.getAmount() * -1);
        }
        newTransaction.setEventDate(new Date());
        return repository.save(newTransaction);
    }
}
