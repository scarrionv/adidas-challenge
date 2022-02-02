package com.scarrionv.subscriptionservice.dtos;

import lombok.Data;

@Data
public class ErrorDto {
    private String type;
    private String message;
    private int status;
}
