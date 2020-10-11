package com.pismo.challenge.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pismo.challenge.enums.OperationsTypesEnum;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Account account;
    private long accountID;
    private OperationsTypesEnum operationType;
    private Double amount;
    private Date eventDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public OperationsTypesEnum getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationsTypesEnum operationType) {
        this.operationType = operationType;
    }

    public long getAccountID() {
        return accountID;
    }

    public void setAccountID(long accountID) {
        this.accountID = accountID;
    }
}
