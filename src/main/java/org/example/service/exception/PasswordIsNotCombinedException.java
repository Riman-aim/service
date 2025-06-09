package org.example.service.exception;

public class PasswordIsNotCombinedException extends RuntimeException {
    public PasswordIsNotCombinedException(String message) {
        super(message);
    }
}
