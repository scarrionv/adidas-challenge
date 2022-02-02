package com.scarrionv.subscriptionservice.respoitories;

import com.scarrionv.subscriptionservice.models.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Subscription Repository
 */
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
}
