package com.webService.webService.exception.exceptions;

public class CustomerExists extends RuntimeException{
   public CustomerExists(String message){
        super(message);
    }
}
