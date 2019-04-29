package com.stackroute.trainermanagementservice.service;

import com.stackroute.trainermanagementservice.domain.Trainer;

import java.util.List;

public interface TrainerService {
    Trainer saveTrainer(Trainer trainer);

    List<Trainer> getAllTrainer();

    List<Trainer> getTrainer();

    void deleteTrainer();


}
