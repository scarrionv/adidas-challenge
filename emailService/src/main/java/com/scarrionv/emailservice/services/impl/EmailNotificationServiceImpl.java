package com.scarrionv.emailservice.services.impl;

import com.scarrionv.emailservice.dtos.SubscriptionDto;
import com.scarrionv.emailservice.services.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailNotificationServiceImpl implements NotificationService {

    public void send(SubscriptionDto subscriptionDto){
        log.info("send -> sending message to email :{}, with body :{}",
                subscriptionDto.getEmail(),
                this.getNotificationBody());
    }
}
