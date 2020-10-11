package com.pismo.challenge.exceptions;

public class NotFoundAccountExeption extends RuntimeException  {

    public NotFoundAccountExeption(Long id) {
        super("Could not find account: "+ id);
    }
}
