package com.stackroute.enrollment.repository;

import com.stackroute.enrollment.domain.Enrollment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends MongoRepository<Enrollment, String> {
}
