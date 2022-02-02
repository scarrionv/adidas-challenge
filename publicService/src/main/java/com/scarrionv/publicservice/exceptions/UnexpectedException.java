package com.scarrionv.publicservice.exceptions;

import org.springframework.http.HttpStatus;

public class UnexpectedException extends BaseException {

    public UnexpectedException(String cause) {
        super(
                "UnexpectedException",
                cause,
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
    }
}
