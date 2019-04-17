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
        return new ResponseEntity<>(trainer1, HttpStatus.CREATED);
    }

    @GetMapping("/subscriptions")
    public ResponseEntity<List<Trainer>> getSubscriptions() {
        List<Trainer> allSubscriptions = trainerService.getAllTrainer();
        return new ResponseEntity<>(allSubscriptions, HttpStatus.OK);
    }


}
