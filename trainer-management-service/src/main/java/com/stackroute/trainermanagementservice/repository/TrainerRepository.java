package com.stackroute.trainermanagementservice.repository;

import com.stackroute.trainermanagementservice.domain.Trainer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends MongoRepository<Trainer,String> {
}
