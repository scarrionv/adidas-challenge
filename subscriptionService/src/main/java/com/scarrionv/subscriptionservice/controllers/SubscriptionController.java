package com.scarrionv.subscriptionservice.controllers;

import com.scarrionv.subscriptionservice.dtos.SubscriptionDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for Subscriptions private api, manage life cycle of subscriptions
 */
@RequestMapping("/api")
public interface SubscriptionController {

        /**
         * Retrieve all subscriptions
         *
         * @return List with all {@link SubscriptionDto} founds
         */
        @GetMapping("/subscriptions")
        List<SubscriptionDto> findSubscriptions();

        /**
         * Create a new subscription
         *
         * @param subscriptionDto Subscription to create
         * @return Id of the new subscription created
         */
        @PostMapping("/subscriptions")
        int addSubscription(@RequestBody SubscriptionDto subscriptionDto);

        /**
         * Retrieve a subscription with a given ID
         *
         * @param subscriptionId ID of the subscription to retrieve
         * @return The {@link SubscriptionDto}
         */
        @GetMapping("/subscriptions/{subscriptionId}")
        SubscriptionDto findSubscriptionById(@PathVariable int subscriptionId);

        /**
         * Delete a subscription with a given ID
         *
         * @param subscriptionId ID of the subscription to delete
         */
        @DeleteMapping("/subscriptions/{subscriptionId}")
        void deleteSubscription(@PathVariable int subscriptionId);
}
