package com.stackroute.programservice.repository;

import com.stackroute.programservice.domain.Program;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProgramRepository extends MongoRepository<Program, String> {


}
