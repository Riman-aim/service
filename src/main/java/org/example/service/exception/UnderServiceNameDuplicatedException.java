package org.example.service.exception;

public class UnderServiceNameDuplicatedException extends RuntimeException {
    public UnderServiceNameDuplicatedException(String message) {
        super(message);
    }
}
