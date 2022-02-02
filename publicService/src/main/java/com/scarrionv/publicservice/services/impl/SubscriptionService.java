package com.scarrionv.publicservice.services.impl;

import com.scarrionv.publicservice.clients.SubscriptionsClient;
import com.scarrionv.publicservice.dtos.SubscriptionDto;
import com.scarrionv.publicservice.models.Subscription;
import com.scarrionv.publicservice.utils.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SubscriptionService implements com.scarrionv.publicservice.services.SubscriptionService {

    private final SubscriptionsClient subscriptionsClient;

    @Autowired
    public SubscriptionService(SubscriptionsClient subscriptionsClient) {
        this.subscriptionsClient = subscriptionsClient;
    }

    @Override
    public List<Subscription> findSubscriptions() {
        List<SubscriptionDto> subscriptionDtoList = this.subscriptionsClient.findSubscriptions();
        return Mapper.mapList(subscriptionDtoList, Subscription.class);
    }

    @Override
    public int addSubscription(Subscription subscription) {
        return this.subscriptionsClient.addSubscription(Mapper.map(subscription, SubscriptionDto.class));
    }

    @Override
    public Optional<Subscription> findSubscriptionById(int id) {
        SubscriptionDto subscriptionDto;
        subscriptionDto = this.subscriptionsClient.findSubscriptionById(id);
        return Optional.of(Mapper.map(subscriptionDto, Subscription.class));
    }

    @Override
    public void deleteSubscription(int id) {
        this.subscriptionsClient.deleteSubscription(id);
    }
}
