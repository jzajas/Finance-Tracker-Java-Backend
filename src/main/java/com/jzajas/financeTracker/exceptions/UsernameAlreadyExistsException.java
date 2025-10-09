package com.jzajas.financeTracker.exceptions;


public class UsernameAlreadyExistsException extends RuntimeException{
    public UsernameAlreadyExistsException(final String message) {
        super(message);
    }
}
