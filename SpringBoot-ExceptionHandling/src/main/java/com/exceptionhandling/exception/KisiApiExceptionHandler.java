package com.exceptionhandling.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class KisiApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public final ResponseEntity<ExceptionResponseModel> illegalException(Exception exception, WebRequest request){
        ExceptionResponseModel exceptionResponseModel=new ExceptionResponseModel(LocalDateTime.now(),"200",exception.getMessage());
        return new ResponseEntity<ExceptionResponseModel>(exceptionResponseModel, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(KisiNotFoundException.class)
    public final ResponseEntity<ExceptionResponseModel> kisiNotFoundException(Exception exception, WebRequest request){
        ExceptionResponseModel exceptionResponseModel=new ExceptionResponseModel(LocalDateTime.now(),"300",exception.getMessage());
        return new ResponseEntity<ExceptionResponseModel>(exceptionResponseModel, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponseModel> exception(Exception exception, WebRequest request){
        ExceptionResponseModel exceptionResponseModel=new ExceptionResponseModel(LocalDateTime.now(),"100",exception.getMessage());
        return new ResponseEntity<ExceptionResponseModel>(exceptionResponseModel, HttpStatus.BAD_REQUEST);
    }
}
