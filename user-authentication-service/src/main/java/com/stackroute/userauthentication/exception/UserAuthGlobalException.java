package com.stackroute.userauthentication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserAuthGlobalException {
    @ExceptionHandler(Exception.class)
    public ResponseEntity handleGeneralException(Exception exception){
        return new ResponseEntity(exception.getMessage(), HttpStatus.CONFLICT);
    }
}
