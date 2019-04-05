package com.stackroute.adminservice.repository;

import com.mongodb.Mongo;
import com.stackroute.adminservice.domain.Program;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepository extends MongoRepository<Program,String> {


}
