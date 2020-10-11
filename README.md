# Desafio das Transações
> Desafio técnico proposto em java pela Pismo. Foi utilizado o Spring Boot/JPA para construção do projeto.



![](header.png)

## Como executar

Maven

```sh
mvnw spring-boot:run
```

## POST em  /accounts

{
 "documentNumber": 222222
}

## POST em /transactions

{
    "accountID":3, "operationType":2, "amount": 400
}



## Tipo de Transações

* 0 - COMPRA A VISTA
* 1 - COMPRA PARCELADA
* 2 - SAQUE
* 3 - PAGAMENTO