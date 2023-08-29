package com.example.demo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.exception.ReviewNotFoundException;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;

@ControllerAdvice
@RequiredArgsConstructor
public class ExcHandler extends ResponseEntityExceptionHandler {
    
    private final ResHandler resHandler;

    @ExceptionHandler(ReviewNotFoundException.class)
    public ResponseEntity<Object> handleNoContent(ReviewNotFoundException e) {

     return resHandler.generateResponse(e.getMessage(), HttpStatus.NOT_FOUND);
   }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<Object> handleExpiredJwtException(ExpiredJwtException e) {

     return resHandler.generateResponse(e.getMessage(), HttpStatus.NOT_FOUND);
   }

}
