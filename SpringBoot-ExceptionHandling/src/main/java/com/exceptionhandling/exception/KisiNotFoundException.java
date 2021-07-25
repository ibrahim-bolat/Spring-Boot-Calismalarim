package com.exceptionhandling.exception;

public class KisiNotFoundException extends RuntimeException{

    public KisiNotFoundException(String message) {
        super(message);
    }
}
