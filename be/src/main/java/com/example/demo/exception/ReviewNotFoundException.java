package com.example.demo.exception;

public class ReviewNotFoundException extends IllegalStateException{
    public ReviewNotFoundException(String message){
        super(message);
    }

}
