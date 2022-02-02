package com.scarrionv.subscriptionservice.services.impl;

import com.scarrionv.subscriptionservice.dtos.SubscriptionDto;
import com.scarrionv.subscriptionservice.services.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailNotificationService implements NotificationService {

    private final StreamBridge streamBridge;

    @Autowired
    public EmailNotificationService(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @Override
    public void notify(SubscriptionDto subscriptionDto) {
        streamBridge.send("queue.subscription.messages", subscriptionDto);
    }

}
