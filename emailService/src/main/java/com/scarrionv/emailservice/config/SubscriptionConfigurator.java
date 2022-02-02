package com.scarrionv.emailservice.config;

import com.scarrionv.emailservice.dtos.SubscriptionDto;
import com.scarrionv.emailservice.services.impl.EmailNotificationServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@Slf4j
public class SubscriptionConfigurator {

    private final EmailNotificationServiceImpl notificationService;

    @Autowired
    public SubscriptionConfigurator(EmailNotificationServiceImpl notificationService) {
        this.notificationService = notificationService;
    }

    /**
     * Consumer to execute for incoming messages from broker and destination subscription
     * This bean is used by spring cloud stream.
     *
     * @return Consumer whose accept functions send a new notification with the notification service
     */
    @Bean
    public Consumer<SubscriptionDto> subscription(){
        return this.notificationService::send;
    }
}
