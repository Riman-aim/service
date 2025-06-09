package org.example.service.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class ServiceNameIsDuplicatedException extends RuntimeException {
    public ServiceNameIsDuplicatedException(String message) {
        super(message);
    }
}
