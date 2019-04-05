package com.stackroute.programschedular.repository;

import com.stackroute.programschedular.domain.ProgramSchedule;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProgramScheduleRepository extends MongoRepository<ProgramSchedule, String> {

}
