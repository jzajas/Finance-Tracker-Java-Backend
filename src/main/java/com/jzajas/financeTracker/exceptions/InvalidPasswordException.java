package com.jzajas.financeTracker.exceptions;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(final String message) {
        super(message);
    }
}
