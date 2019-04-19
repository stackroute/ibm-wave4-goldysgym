package com.stackroute.trainermanagementservice.controller;

import com.stackroute.trainermanagementservice.component.JsonParser;
import com.stackroute.trainermanagementservice.component.TrainerAllocation;
import com.stackroute.trainermanagementservice.domain.Trainer;
import com.stackroute.trainermanagementservice.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api/v3")
public class TrainerController {
    private JsonParser jsonParser;
    private TrainerService trainerService;

    @Autowired
    private TrainerAllocation trainerAllocation;
    @Autowired
    public TrainerController(TrainerService trainerService,JsonParser jsonParser) {
        this.trainerService = trainerService;
        this.jsonParser=jsonParser;

    }

    @PostMapping("/trainer")
    public ResponseEntity<Trainer> saveTrainer(@RequestBody @Valid Trainer trainer) throws FileNotFoundException {
        Trainer trainer1 = trainerService.saveTrainer(trainer);

       // jsonParser.parser();
        return new ResponseEntity<Trainer>(trainer1, HttpStatus.CREATED);
    }

    @GetMapping("/trainers")
    public ResponseEntity<List<Trainer>> getTrainers() {
        List<Trainer> allTrainer = trainerService.getAllTrainer();

        return new ResponseEntity<List<Trainer>>(allTrainer, HttpStatus.OK);
    }
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
    @DeleteMapping("/deletetrainer")
    public ResponseEntity<List<Trainer>> deleteTrainer() throws Exception {
//        if(trainerService.getSubscriptionById(subscriptionId)==null)
//            throw new Exception();
        trainerService.deleteTrainer();
        List<Trainer> allTrainers = trainerService.getAllTrainer();
        return new ResponseEntity<List<Trainer>>(allTrainers, HttpStatus.OK);
    }




}
