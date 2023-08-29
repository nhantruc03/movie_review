package com.example.demo.handler;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.demo.model.Body;
import com.example.demo.model.Header;
import com.example.demo.model.ResponseMessage;

@Component
public class ResHandler {

    public ResponseEntity<Object> generateResponse(Object data, HttpStatus httpStatus){

        List<Integer> listSuccessCode = Arrays.asList(200,201);

        String message = listSuccessCode.contains(httpStatus.value()) ? "Success" : "Error";

        Header header = Header.builder()
            .message(message)
            .statusCode(httpStatus.value())
            .timeStamp(LocalDateTime.now())
            .build();
        
        Body body = new Body(data);
        
        ResponseMessage res = ResponseMessage.builder()
            .header(header)
            .body(body)
            .build();


        return new ResponseEntity<>(res, httpStatus);
    }
    
}
