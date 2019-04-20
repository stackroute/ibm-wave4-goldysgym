package com.stackroute.programschedular.domain;

import java.sql.Date;

public class UserDto {
    Date date;
    String time;
    String users;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public UserDto() {
    }

    public UserDto(Date date, String time, String users) {
        this.date = date;
        this.time = time;
        this.users = users;
    }
}
