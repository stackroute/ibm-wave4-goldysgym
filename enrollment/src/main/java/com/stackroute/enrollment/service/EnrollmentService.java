package com.stackroute.enrollment.service;

import com.stackroute.enrollment.domain.Enrollment;

<<<<<<< HEAD
=======
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
>>>>>>> 13c0d7bcfb56404df1a4d703cb35e28fba59a35b
import java.util.List;

public interface EnrollmentService
{
    public Enrollment saveEnrollment(Enrollment enrollment);
    public List<Enrollment> getALLRest();
    public Enrollment findbyId(String id);
    public void delete(String id);

<<<<<<< HEAD
=======

    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }


    public Enrollment saveEnrollment(Enrollment enrollment)
    {
        Calendar calendar = Calendar.getInstance();
       Subscription subscription = enrollment.getSubscription();
       int duration=subscription.getDuration();
        calendar.setTime(enrollment.getStartDate());
        calendar.add(Calendar.MONTH, duration);
        Date futureDate =calendar.getTime();
       enrollment.setEndDate(futureDate);
        enrollment.setStartDate(new Date());
        Enrollment enrollment1=enrollmentRepository.save(enrollment);
        return  enrollment1;
    }
    public List<Enrollment> getALLRest(){
        return (List<Enrollment>)enrollmentRepository.findAll();
    }
    public Enrollment findbyId(String id) {
        return enrollmentRepository.findById(id).get();
    }
    public void delete(String id)
    {
        enrollmentRepository.deleteById(id);
>>>>>>> 13c0d7bcfb56404df1a4d703cb35e28fba59a35b
    }
