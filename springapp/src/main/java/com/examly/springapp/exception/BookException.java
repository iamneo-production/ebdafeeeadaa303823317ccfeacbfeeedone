package com.examly.springapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class BookException {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Object> handleBookNotFoundException(BookNotFoundException ex, WebRequest request) {
        String errorMessage = ex.getMessage();
        // You can perform additional logic, logging, or custom response formatting here if needed.
        // For now, we'll just return the error message as JSON in the response body.
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
