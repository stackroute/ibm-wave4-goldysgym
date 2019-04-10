package com.stackroute.programschedular.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Morning {
    Program program;

    public Morning() {
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
}
