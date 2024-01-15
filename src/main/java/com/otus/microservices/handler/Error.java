package com.otus.microservices.handler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Error {

    private Integer code;
    private String message;
}
