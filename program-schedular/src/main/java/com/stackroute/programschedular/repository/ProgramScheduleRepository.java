package com.stackroute.programschedular.repository;

import com.stackroute.programschedular.domain.Year;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramScheduleRepository extends MongoRepository<Year, String> {

}
