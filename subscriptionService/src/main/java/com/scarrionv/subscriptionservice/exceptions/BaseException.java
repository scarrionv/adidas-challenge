package com.scarrionv.subscriptionservice.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
/**
 * Base exception for the application
 */
abstract class BaseException extends RuntimeException{
    private final String type;
    private final String message;
    private final int status;
}
