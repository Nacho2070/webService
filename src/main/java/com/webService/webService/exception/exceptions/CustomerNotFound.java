package com.webService.webService.exception.exceptions;

public class CustomerNotFound extends RuntimeException {
    public CustomerNotFound(String message){
        super(message);
    }
}
