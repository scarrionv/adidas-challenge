package com.scarrionv.subscriptionservice.services;

import com.scarrionv.subscriptionservice.dtos.SubscriptionDto;

/**
 * Notification Service that manage the notification of new subscriptions
 */
public interface NotificationService {
    /**
     * Notify the creation of a new Subscription
     *
     * @param subscriptionDto new Subscription to notify
     */
    void notify(SubscriptionDto subscriptionDto);
}
