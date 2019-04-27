package com.stackroute.trainermanagementservice.service;

import com.stackroute.trainermanagementservice.domain.Trainer;
import com.stackroute.trainermanagementservice.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {

    private TrainerRepository trainerRepository;

    @Autowired
    public TrainerServiceImpl(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Override
    public Trainer saveTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }
    @Override
    public List<Trainer> getAllTrainer() {
        return trainerRepository.findAll();
    }

    @Override
    public List<Trainer> getTrainer() {
        return trainerRepository.getByavailability(false);
    }

    @Override

    public void deleteTrainer() {
        trainerRepository.deleteAll();
    }


}
