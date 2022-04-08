package com.address.book.addressbookapi.exceptionhandling;


import org.apache.velocity.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(HandleExceptions.class);

    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
    @ExceptionHandler(ResourceAccessException.class)
    public String handleConnectionTimeOut(ResourceAccessException ex) {
        logger.error("error occur with ResourceAccessException");
        return "Connection has been time out";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public List<String> handleConnectionTimeOut(ConstraintViolationException ex) {
        logger.error("error occur with ConstraintViolationException");
        ArrayList<String> listOfErrors = new ArrayList<>();
        ex.getConstraintViolations().forEach(err -> listOfErrors.add(err.getMessage()));
        return listOfErrors;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleSourceNotFound(ResourceNotFoundException ex) {
        logger.error("error occur with ResourceNotFoundException");
        return ex.getMessage();
    }

    @ExceptionHandler(ListEmptyException.class)
    public String handleListNotFound(ListEmptyException ex) {
        logger.error("error occur with ListEmptyException");
        return "List is empty";
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NullPointerException.class)
    public String handleNullPointer(NullPointerException ex) {
        logger.error("error occur with NullPointerException");
        return ex.getMessage();
    }
}
