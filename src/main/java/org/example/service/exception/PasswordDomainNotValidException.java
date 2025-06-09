package org.example.service.exception;

public class PasswordDomainNotValidException extends RuntimeException {
    public PasswordDomainNotValidException(String message) {
        super(message);
    }
}
