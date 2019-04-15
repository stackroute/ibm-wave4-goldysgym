package com.stackroute.trainermanagementservice.controller;

import com.stackroute.trainermanagementservice.domain.Trainer;
import com.stackroute.trainermanagementservice.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v3")
public class TrainerController {

    private TrainerService trainerService;

    @Autowired
    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @PostMapping("/trainer")
    public ResponseEntity<Trainer> saveSubscription(@RequestBody @Valid Trainer trainer) {
        Trainer trainer1 = trainerService.saveTrainer(trainer);
        return new ResponseEntity<Trainer>(trainer1, HttpStatus.CREATED);
    }

//    @GetMapping("/subscriptions")
//    public ResponseEntity<List<Subscription>> getSubscriptions() {
//        List<Subscription> allSubscriptions = subscriptionService.getAllSubscription();
//        return new ResponseEntity<List<Subscription>>(allSubscriptions, HttpStatus.OK);
//    }
//
//    @GetMapping("/subscriptions/{subscriptionId}")
//    public ResponseEntity<Subscription> getSubscriptionById(@PathVariable String subscriptionId) throws Exception {
//        Subscription subscriptionById = subscriptionService.getSubscriptionById(subscriptionId);
//        if(subscriptionById==null)
//            throw new Exception();
//        return new ResponseEntity<Subscription>(subscriptionById, HttpStatus.OK);
//
//    }
//
//    @PutMapping("/subscription")
//    public ResponseEntity<Subscription> updateSubscription(@RequestBody Subscription subscription) {
//        Subscription updatedSubscription = subscriptionService.updateSubscription(subscription);
//        return new ResponseEntity<Subscription>(updatedSubscription, HttpStatus.ACCEPTED);
//    }
//
//    @DeleteMapping("/subscriptions/{subscriptionId}")
//    public ResponseEntity<List<Subscription>> deleteSubscription(@PathVariable String subscriptionId) throws Exception {
//        if(subscriptionService.getSubscriptionById(subscriptionId)==null)
//            throw new Exception();
//        subscriptionService.deleteSubscription(subscriptionId);
//        List<Subscription> allSubscriptions = subscriptionService.getAllSubscription();
//        return new ResponseEntity<List<Subscription>>(allSubscriptions, HttpStatus.OK);
//    }
}
