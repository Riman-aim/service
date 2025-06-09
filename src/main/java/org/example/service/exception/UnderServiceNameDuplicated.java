package org.example.service.exception;

public class UnderServiceNameDuplicated extends RuntimeException {
    public UnderServiceNameDuplicated(String message) {
        super(message);
    }
}
