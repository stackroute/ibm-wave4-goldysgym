package com.stackroute.programschedular.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Year {
    @Id
    String year;
    Month[] month = new Month[12];

    public Year() {
    }

    public Year(String year, Month[] month) {
        this.year = year;
        this.month = month;
    }

    public Month[] getMonth() {
        return month;
    }

    public void setMonth(Month[] month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
