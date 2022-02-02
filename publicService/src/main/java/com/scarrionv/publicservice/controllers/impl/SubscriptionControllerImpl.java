package com.scarrionv.publicservice.controllers.impl;

import com.scarrionv.publicservice.controllers.SubscriptionController;
import com.scarrionv.publicservice.dtos.SubscriptionDto;
import com.scarrionv.publicservice.exceptions.SubscriptionNotFoundException;
import com.scarrionv.publicservice.models.Subscription;
import com.scarrionv.publicservice.services.SubscriptionService;
import com.scarrionv.publicservice.utils.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class SubscriptionControllerImpl implements SubscriptionController {

    private final SubscriptionService subscribable;

    @Autowired
    public SubscriptionControllerImpl(SubscriptionService subscribable) {
        this.subscribable = subscribable;
    }

    @Override
    public List<SubscriptionDto> findSubscriptions() {
        log.info("findSubscriptions -> called");
        List<Subscription> subscriptionList = this.subscribable.findSubscriptions();
        return Mapper.mapList(subscriptionList, SubscriptionDto.class);
    }

    @Override
    public int addSubscription(SubscriptionDto subscriptionDto) {
        log.info("addSubscription -> called with params - subscriptionDto: {}", subscriptionDto);
        return this.subscribable.addSubscription(Mapper.map(subscriptionDto, Subscription.class));
    }

    @Override
    public SubscriptionDto findSubscriptionById(int subscriptionId) {
        log.info("findSubscriptionById -> called with params - subscriptionId: {}", subscriptionId);
        Subscription subscription = this.subscribable.findSubscriptionById(subscriptionId)
                .orElseThrow(() -> new SubscriptionNotFoundException(subscriptionId));
        return Mapper.map(subscription, SubscriptionDto.class);
    }

    @Override
    public void deleteSubscription(int subscriptionId) {
        log.info("deleteSubscription -> called with params - subscriptionId: {}", subscriptionId);
        this.subscribable.deleteSubscription(subscriptionId);
    }
}
