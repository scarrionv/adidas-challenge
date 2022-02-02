package com.scarrionv.subscriptionservice.services.impl;

import com.scarrionv.subscriptionservice.dtos.SubscriptionDto;
import com.scarrionv.subscriptionservice.models.Subscription;
import com.scarrionv.subscriptionservice.respoitories.SubscriptionRepository;
import com.scarrionv.subscriptionservice.services.NotificationService;
import com.scarrionv.subscriptionservice.services.SubscriptionService;
import com.scarrionv.subscriptionservice.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final NotificationService notificationService;

    @Autowired
    public SubscriptionServiceImpl(
            SubscriptionRepository subscriptionRepository,
            NotificationService notificationService
    ) {
        this.subscriptionRepository = subscriptionRepository;
        this.notificationService = notificationService;
    }

    @Override
    @Transactional(readOnly=true)
    public List<Subscription> findSubscriptions() {
        return this.subscriptionRepository.findAll();
    }

    @Override
    @Transactional
    public int addSubscription(Subscription subscription) {
        subscription = this.subscriptionRepository.save(subscription);
        this.notificationService.notify(Mapper.map(subscription, SubscriptionDto.class));
        return subscription.getId();
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<Subscription> findSubscriptionById(int id) {
        return this.subscriptionRepository.findById(id);
    }

    @Override
    @Transactional
    public void deleteSubscription(int id) {
        this.subscriptionRepository.deleteById(id);
    }
}
