package com.stackroute.enrollment.service;

import com.stackroute.enrollment.domain.Enrollment;


import java.util.List;

public interface EnrollmentService {
    public Enrollment saveEnrollment(Enrollment enrollment);

    public List<Enrollment> getALLRest();

    public Enrollment findbyId(String id);

    public void delete(String id);

}
