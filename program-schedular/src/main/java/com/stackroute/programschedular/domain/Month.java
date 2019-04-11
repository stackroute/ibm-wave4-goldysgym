package com.stackroute.programschedular.domain;

import org.springframework.data.annotation.Id;

public class Month {
    String monthName;
    Day[] days = new Day[31];

    public Month() {
    }

    public Month(String monthName, Day[] days) {
        this.monthName = monthName;
        this.days = days;
    }

    public Day[] getDays() {
        return days;
    }

    public void setDays(Day[] days) {
        this.days = days;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }
}
