package org.example.service.service;


import org.example.service.exception.*;
import org.example.service.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionManager {

    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ExceptionHandler(ServiceNameIsDuplicatedException.class)
    public ExceptionResponse serviceNameIsDuplicatedExceptionHandler(ServiceNameIsDuplicatedException e){
        return new ExceptionResponse(e.getMessage(), LocalDate.now());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(AdminNotFoundException.class)
    public ExceptionResponse adminNotFoundExceptionHandler(AdminNotFoundException e){
        return new ExceptionResponse(e.getMessage(), LocalDate.now());
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UnderServiceNameDuplicated.class)
    public ExceptionResponse underServiceNameDuplicatedExceptionHandler(UnderServiceNameDuplicated e){
        return new ExceptionResponse(e.getMessage(), LocalDate.now());
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(ServiceNotExistException.class)
    public ExceptionResponse serviceNotExistExceptionHandler(ServiceNotExistException e){
        return new ExceptionResponse(e.getMessage(), LocalDate.now());
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UnderServiceNameDuplicatedException.class)
    public ExceptionResponse underServiceNameDuplicatedExceptionHandler(UnderServiceNameDuplicatedException e){
        return new ExceptionResponse(e.getMessage(), LocalDate.now());
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PasswordDomainNotValidException.class)
    public ExceptionResponse passwordDomainNotValidExceptionHandler(PasswordDomainNotValidException e){
        return new ExceptionResponse(e.getMessage(), LocalDate.now());
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PasswordIsNotCombinedException.class)
    public ExceptionResponse passwordIsNotCombinedExceptionHandler(PasswordIsNotCombinedException e){
        return new ExceptionResponse(e.getMessage(), LocalDate.now());
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmailDuplicatedException.class)
    public ExceptionResponse emailDuplicatedExceptionHandler(EmailDuplicatedException e){
        return new ExceptionResponse(e.getMessage(), LocalDate.now());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }




}
