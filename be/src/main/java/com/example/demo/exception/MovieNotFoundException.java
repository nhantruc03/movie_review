package com.example.demo.exception;

public class MovieNotFoundException extends IllegalStateException{
    public MovieNotFoundException (String message){
        super(message);
    }
}
