package com.webService.webService.exception;

import com.webService.webService.exception.exceptions.CustomerExists;
import com.webService.webService.exception.exceptions.CustomerNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({CustomerNotFound.class})
    public ResponseEntity<?> userNotFoundException(CustomerNotFound exception, WebRequest webRequest){
        return new ResponseEntity<>(new ErrorDetails(new Date(), exception.getMessage(), webRequest.getDescription(false)), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler({CustomerExists.class})
    public ResponseEntity<?> userNotFoundException(CustomerExists exception, WebRequest webRequest){
        return new ResponseEntity<>(new ErrorDetails(new Date(), exception.getMessage(), webRequest.getDescription(false)), HttpStatus.NOT_FOUND);
    }
}
