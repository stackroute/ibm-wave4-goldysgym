package com.stackroute.programschedular.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Evening {
Program program;

    public Evening() {
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
}
