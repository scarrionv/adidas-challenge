package com.scarrionv.publicservice.controllers;

import com.scarrionv.publicservice.dtos.SubscriptionDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for subscriptions public api, that manage the life cycle of a subscription
 */
@RequestMapping("/api")
public interface SubscriptionController {

        @GetMapping("/subscriptions")
        List<SubscriptionDto> findSubscriptions();

        @PostMapping("/subscriptions")
        int addSubscription(@RequestBody SubscriptionDto subscriptionDto);

        @GetMapping("/subscriptions/{subscriptionId}")
        SubscriptionDto findSubscriptionById(@PathVariable int subscriptionId);

        @DeleteMapping("/subscriptions/{subscriptionId}")
        void deleteSubscription(@PathVariable int subscriptionId);
}
