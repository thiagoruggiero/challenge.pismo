package com.pismo.challenge.exceptions;

public class NotFoundExeption extends RuntimeException  {

    public NotFoundExeption(Long id) {
        super("Could not find: " + id);
    }
}
