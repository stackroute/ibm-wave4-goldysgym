package com.stackroute.enrollment.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class Enrollment
{
    @Id
    String userId;
    String firstName;
    String lastName;
    String email;
    String password;
    LocalDate DateOfBirth;
    String gender;
    Double Height;
    Double Weight;
    int interest[]= new int[3];
    LocalDate StartDate;
    LocalDate EndDate;
    Subscription subscription;
    Double price;
    String EnrollmentName;
    int Duration;LocalDate startDate;
 LocalDate endDate;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getHeight() {
        return Height;
    }

    public void setHeight(Double height) {
        Height = height;
    }

    public Double getWeight() {
        return Weight;
    }

    public void setWeight(Double weight) {
        Weight = weight;
    }

    public int[] getInterest() {
        return interest;
    }

    public void setInterest(int[] interest) {
        this.interest = interest;
    }

    public LocalDate getStartDate() {
        return StartDate;
    }

    public void setStartDate(LocalDate startDate) {
        StartDate = startDate;
    }

    public LocalDate getEndDate() {
        return EndDate;
    }

    public void setEndDate(LocalDate endDate) {
        EndDate = endDate;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getEnrollmentName() {
        return EnrollmentName;
    }

    public void setEnrollmentName(String enrollmentName) {
        EnrollmentName = enrollmentName;
    }

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int duration) {
        Duration = duration;
    }
}
