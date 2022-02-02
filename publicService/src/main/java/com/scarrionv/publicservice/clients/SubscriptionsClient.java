package com.scarrionv.publicservice.clients;

import com.scarrionv.publicservice.configurations.FeignClientConfiguration;
import com.scarrionv.publicservice.dtos.SubscriptionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        name = "${feign.client.subscriptions.name}",
        url = "${feign.client.subscriptions.url}",
        configuration = FeignClientConfiguration.class
)
public interface SubscriptionsClient {

        @GetMapping("/subscriptions")
        List<SubscriptionDto> findSubscriptions();

        @PostMapping("/subscriptions")
        int addSubscription(@RequestBody SubscriptionDto subscriptionDto);

        @GetMapping("/subscriptions/{subscriptionId}")
        SubscriptionDto findSubscriptionById(@PathVariable int subscriptionId);

        @DeleteMapping("/subscriptions/{subscriptionId}")
        void deleteSubscription(@PathVariable int subscriptionId);

}

