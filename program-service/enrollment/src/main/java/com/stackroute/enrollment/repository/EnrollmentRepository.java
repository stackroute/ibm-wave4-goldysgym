package com.stackroute.enrollment.repository;

import com.stackroute.enrollment.domain.Enrollment;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface EnrollmentRepository extends MongoRepository<Enrollment,String> {
}
