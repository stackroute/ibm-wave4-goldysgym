package com.stackroute.subscriptionservice.service;

import com.stackroute.subscriptionservice.domain.Subscription;

import java.util.List;

public interface SubscriptionService {
    Subscription saveSubscription(Subscription subscription);

    List<Subscription> getAllSubscription();

    Subscription getSubscriptionById(String subscriptionId);

    Subscription updateSubscription(Subscription subscription);

    void deleteSubscription(String subscriptionId);
}
