package com.scarrionv.emailservice.services;

import com.scarrionv.emailservice.dtos.SubscriptionDto;

/**
 * Send notification
 */
public interface NotificationService {

    // FIXME: In our business logic we should use the bussiness model object instead of the DTO object
    /**
     *
     * Send a notification to the user of the subscription
     *
     * @param subscriptionDto the subscription to notify
     */
    void send(SubscriptionDto subscriptionDto);

    /**
     * Retrieeve the body of the notification
     *
     * @return String with the body to send in the notification
     */
    default String getNotificationBody(){
        return "Hi, you have been subscribed successfully";
    }

}
