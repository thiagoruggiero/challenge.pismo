package com.pismo.challenge.service;

import com.pismo.challenge.entity.Account;
import com.pismo.challenge.entity.Transaction;
import com.pismo.challenge.exceptions.NotFoundAccountExeption;
import com.pismo.challenge.repository.AccountRepository;
import com.pismo.challenge.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import static com.pismo.challenge.enums.OperationsTypesEnum.PAGAMENTO;

import java.util.Date;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    public Transaction newTransaction(Transaction newTransaction) {
        newTransaction.setAccount(getAccount(newTransaction));
        negativeAmountIfNecessary(newTransaction);
        return saveTransaction(newTransaction);
    }

    private Account getAccount(Transaction newTransaction) {
        return accountRepository.findById(newTransaction.getAccountID()).orElseThrow(() -> new NotFoundAccountExeption(newTransaction.getAccountID()));
    }

    private Transaction saveTransaction(Transaction newTransaction) {
        newTransaction.setEventDate(new Date());
        return transactionRepository.save(newTransaction);
    }

    private void negativeAmountIfNecessary(Transaction newTransaction) {
        if (newTransaction.getOperationType() != PAGAMENTO){
            newTransaction.setAmount(newTransaction.getAmount() * -1);
        }
    }
}
