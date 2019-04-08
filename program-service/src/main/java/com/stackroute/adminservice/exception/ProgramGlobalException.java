package com.stackroute.adminservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ProgramGlobalException {
    @ExceptionHandler(Exception.class)
    public ResponseEntity handleGeneralException(Exception exception){
        return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
