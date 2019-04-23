package com.stackroute.programservice.service;

import com.stackroute.programservice.domain.Program;

import java.util.Date;
import java.util.List;

public interface ProgramService {
    Program saveProgram(Program program);

    List<Program> getAllPrograms();

    Program getProgramById(String programId);

    List<Program> getProgramByDate(Date date);

    Program updateProgram(Program program);

    void deleteProgramById(String programId);

    void deleteProgram();
}
