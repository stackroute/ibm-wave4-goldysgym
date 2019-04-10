package com.stackroute.programschedular.repository;

import com.stackroute.programschedular.domain.ProgramSchedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramScheduleRepository extends MongoRepository<ProgramSchedule, String> {

}
