package com.stackroute.subscriptionservice.controller;

import com.stackroute.subscriptionservice.domain.Subscription;
import com.stackroute.subscriptionservice.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class SubscriptionController {

    private SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping("/subscription")
    public ResponseEntity<Subscription> saveSubscription(@RequestBody Subscription subscription) {
        Subscription subscriptionAdded = subscriptionService.saveSubscription(subscription);
        return new ResponseEntity<Subscription>(subscriptionAdded, HttpStatus.CREATED);
    }

    @GetMapping("/subscriptions")
    public ResponseEntity<List<Subscription>> getSubscriptions() {
        List<Subscription> allSubscriptions = subscriptionService.getAllSubscription();
        return new ResponseEntity<List<Subscription>>(allSubscriptions, HttpStatus.OK);
    }

    @GetMapping("/subscriptions/{subscriptionId}")
    public ResponseEntity<Subscription> getSubscriptionById(@PathVariable String subscriptionId) {
        Subscription subscriptionById = subscriptionService.getSubscriptionById(subscriptionId);
        return new ResponseEntity<Subscription>(subscriptionById, HttpStatus.OK);

    }

    @PutMapping("/subscription")
    public ResponseEntity<Subscription> updateSubscription(@RequestBody Subscription subscription) {
        Subscription updatedSubscription = subscriptionService.updateSubscription(subscription);
        return new ResponseEntity<Subscription>(updatedSubscription, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/subscriptions/{subscriptionId}")
    public ResponseEntity<List<Subscription>> deleteSubscription(@PathVariable String subscriptionId) {
        subscriptionService.deleteSubscription(subscriptionId);
        List<Subscription> allSubscriptions = subscriptionService.getAllSubscription();
        return new ResponseEntity<List<Subscription>>(allSubscriptions, HttpStatus.OK);
    }
}
