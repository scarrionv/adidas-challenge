package com.scarrionv.subscriptionservice.services;

import com.scarrionv.subscriptionservice.models.Subscription;

import java.util.List;
import java.util.Optional;

/**
 * Subscription service to manage subscriptions
 */
public interface SubscriptionService {
    /**
     * Retrieve all subscriptions
     *
     * @return List with all {@link Subscription} founds
     */
    List<Subscription> findSubscriptions();

    /**
     * Create a new subscription
     *
     * @param subscription Subscription to create
     * @return Id of the new subscription created
     */
    int addSubscription(final Subscription subscription);

    /**
     * Retrieve a subscription with a given ID
     *
     * @param id ID of the subscription to retrieve
     * @return Optional with the subscription if found
     */
    Optional<Subscription> findSubscriptionById(final int id);

    /**
     * Delete a subscription with a given ID
     *
     * @param id ID of the subscription to delete
     */
    void deleteSubscription(final int id);
}
