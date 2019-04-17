package com.stackroute.subscriptionservice.repository;

import com.stackroute.subscriptionservice.domain.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends MongoRepository<Subscription, String> {
}
