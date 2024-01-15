package com.otus.microservices.exception;

public class InvalidDataPersistenceException extends RuntimeException {

    public InvalidDataPersistenceException(String message) {
        super(message);
    }
}
