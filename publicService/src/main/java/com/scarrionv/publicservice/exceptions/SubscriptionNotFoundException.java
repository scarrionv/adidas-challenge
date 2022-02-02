package com.scarrionv.publicservice.exceptions;

import org.springframework.http.HttpStatus;

public class SubscriptionNotFoundException extends BaseException {

    public SubscriptionNotFoundException(long id) {
        super(
                "SubscriptionNotFoundException",
                "Subscription with id " + id + " not found",
                HttpStatus.NOT_FOUND.value()
        );
    }
}
