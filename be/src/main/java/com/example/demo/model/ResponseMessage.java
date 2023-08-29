package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseMessage {

    private Header header;
    private Body body;

}