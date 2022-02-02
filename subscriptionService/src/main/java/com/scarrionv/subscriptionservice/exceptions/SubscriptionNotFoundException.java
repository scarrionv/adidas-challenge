package com.scarrionv.subscriptionservice.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Exception thrown when a given Subscription is not found
 */
public class SubscriptionNotFoundException extends BaseException {

    public SubscriptionNotFoundException(long id) {
        super(
                "SubscriptionNotFoundException",
                "Subscription with id " + id + " not found",
                HttpStatus.NOT_FOUND.value()
        );
    }
}
