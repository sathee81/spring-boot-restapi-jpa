package com.sajl.cruddemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestExceptionHandler
{
    @ExceptionHandler
    public ResponseEntity<EmployeeResponse> handleException (EmployeeNotFoundException exec )
    {
        EmployeeResponse error = new EmployeeResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage( exec.getMessage() );
        error.setTimestamp( System.currentTimeMillis() );
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND );
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeResponse> handleException (Exception exec )
    {
        EmployeeResponse error = new EmployeeResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage( exec.getMessage() );
        error.setTimestamp( System.currentTimeMillis() );
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST );
    }
}
