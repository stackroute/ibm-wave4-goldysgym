package com.stackroute.subscriptionservice.controller;

import com.stackroute.subscriptionservice.domain.Subscription;
import com.stackroute.subscriptionservice.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v2")
public class SubscriptionController {

    private SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping("/subscription")
    public ResponseEntity<Subscription> saveSubscription(@RequestBody @Valid Subscription subscription) {
        Subscription subscriptionAdded = subscriptionService.saveSubscription(subscription);
        return new ResponseEntity<>(subscriptionAdded, HttpStatus.CREATED);
    }

    @GetMapping("/subscriptions")
    public ResponseEntity<List<Subscription>> getSubscriptions() {
        List<Subscription> allSubscriptions = subscriptionService.getAllSubscription();
        return new ResponseEntity<>(allSubscriptions, HttpStatus.OK);
    }

    @GetMapping("/subscriptions/{subscriptionId}")
    public ResponseEntity<Subscription> getSubscriptionById(@PathVariable String subscriptionId) throws Exception {
        Subscription subscriptionById = subscriptionService.getSubscriptionById(subscriptionId);
        if (subscriptionById == null)
            throw new Exception();
        return new ResponseEntity<>(subscriptionById, HttpStatus.OK);

    }

    @PutMapping("/subscription")
    public ResponseEntity<Subscription> updateSubscription(@RequestBody Subscription subscription) {
        Subscription updatedSubscription = subscriptionService.updateSubscription(subscription);
        return new ResponseEntity<>(updatedSubscription, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/subscriptions/{subscriptionId}")
    public ResponseEntity<List<Subscription>> deleteSubscription(@PathVariable String subscriptionId) throws Exception {
        if (subscriptionService.getSubscriptionById(subscriptionId) == null)
            throw new Exception();
        subscriptionService.deleteSubscription(subscriptionId);
        List<Subscription> allSubscriptions = subscriptionService.getAllSubscription();
        return new ResponseEntity<>(allSubscriptions, HttpStatus.OK);
    }
}
