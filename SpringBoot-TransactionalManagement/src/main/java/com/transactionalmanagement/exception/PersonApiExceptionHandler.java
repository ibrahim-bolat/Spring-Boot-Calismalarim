package com.transactionalmanagement.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class PersonApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PersonNotFoundException.class)
    public final ResponseEntity<ExceptionResponseModel> kisiNotFoundException(Exception exception, WebRequest request){
        ExceptionResponseModel exceptionResponseModel=new ExceptionResponseModel(LocalDateTime.now(),"300",exception.getMessage());
        return new ResponseEntity<ExceptionResponseModel>(exceptionResponseModel, HttpStatus.BAD_REQUEST);
    }
}
