package com.stackroute.programservice.service;

import com.stackroute.programservice.domain.Program;

import java.util.List;

public interface ProgramService {
    Program saveProgram(Program program);

    List<Program> getAllPrograms();

    Program getProgramById(String programId);

    Program updateProgram(Program program);

    void deleteProgram(String programId);
}
