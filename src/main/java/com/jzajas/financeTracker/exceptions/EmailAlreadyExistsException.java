package com.jzajas.financeTracker.exceptions;


public class EmailAlreadyExistsException extends RuntimeException{
    public EmailAlreadyExistsException(final String message) {
        super(message);
    }
}
