package com.stackroute.trainermanagementservice.repository;

import com.stackroute.trainermanagementservice.domain.Trainer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerRepository extends MongoRepository<Trainer, String> {

    List<Trainer> getByavailability(Boolean value);
}
