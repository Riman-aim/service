package org.example.service.exception;

public class ServiceNotExistException extends RuntimeException {
    public ServiceNotExistException(String message) {
        super(message);
    }
}
