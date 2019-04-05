package com.stackroute.subscriptionservice.service;


import com.stackroute.subscriptionservice.domain.Subscription;
import com.stackroute.subscriptionservice.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private SubscriptionRepository repository;

    @Autowired
    public SubscriptionServiceImpl(SubscriptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Subscription saveSubscription(Subscription subscription) {
        return repository.save(subscription);
    }

    @Override
    public List<Subscription> getAllSubscription() {
        return repository.findAll();
    }

    @Override
    public Subscription getSubscriptionById(String subscriptionId) {
        return repository.findById(subscriptionId).get();
    }

    @Override
    public Subscription updateSubscription(Subscription subscription) {
        return repository.save(subscription);
    }

    @Override
    public void deleteSubscription(String subscriptionId) {
        repository.deleteById(subscriptionId);
    }
}
