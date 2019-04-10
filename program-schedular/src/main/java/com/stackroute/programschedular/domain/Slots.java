package com.stackroute.programschedular.domain;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Slots {
    String time;
    String programName;
    int capacity;
    List<String> users = new ArrayList<String>();

    public Slots() {
    }

    public Slots(String time, String programName, int capacity, List<String> users) {
        this.time = time;
        this.programName = programName;
        this.capacity = capacity;
        this.users = users;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getprogramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }
}
