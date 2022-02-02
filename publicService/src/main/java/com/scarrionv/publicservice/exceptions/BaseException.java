package com.scarrionv.publicservice.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
abstract class BaseException extends RuntimeException{
    private final String type;
    private final String message;
    private final int status;
}
