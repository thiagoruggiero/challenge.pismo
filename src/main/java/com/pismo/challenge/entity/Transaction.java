package com.pismo.challenge.entity;

import com.pismo.challenge.enums.OperationsTypesEnum;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Account account;
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
}
