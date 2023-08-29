package com.example.demo.model;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Header {
    private String message;
    private int statusCode;
    private LocalDateTime timeStamp;
}
