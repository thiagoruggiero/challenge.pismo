package com.pismo.challenge.entity;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String documentNumber;
    @Column(nullable = false)
    private Double availableCreditLimit;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Double getAvailableCreditLimit() {
        return availableCreditLimit;
    }

    public void setAvailableCreditLimit(Double availableCreditLimit) {
        this.availableCreditLimit = availableCreditLimit;
    }
}
