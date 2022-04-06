package com.address.book.addressbookapi.exceptionHandling;


import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class HandleExceptions {

    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
    @ExceptionHandler(ResourceAccessException.class)
    public String handleConnectionTimeOut(ResourceAccessException ex) {
        return "Connection has been time out";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public List<String> handleConnectionTimeOut(ConstraintViolationException ex) {
        ArrayList<String> listOfErrors = new ArrayList<>();
        ex.getConstraintViolations().forEach(err -> listOfErrors.add(err.getMessage()));
        return listOfErrors;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleSourceNotFound(ResourceNotFoundException ex) {
        return ex.getMessage();
    }

//    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(ListEmptyException.class)
    public String handleListNotFound() {
        return "List is empty";
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NullPointerException.class)
    public String handleNullPointer(NullPointerException ex) {
        return ex.getMessage();
    }
}
