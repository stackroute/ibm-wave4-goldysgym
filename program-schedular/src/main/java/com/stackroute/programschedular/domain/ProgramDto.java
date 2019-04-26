package com.stackroute.programschedular.domain;

import java.sql.Date;

public class ProgramDto {
   String date;
    String time;
    String program;

    public ProgramDto() {
    }

    public ProgramDto(String date, String time, String program) {
        this.date = date;
        this.time = time;
        this.program = program;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
}
