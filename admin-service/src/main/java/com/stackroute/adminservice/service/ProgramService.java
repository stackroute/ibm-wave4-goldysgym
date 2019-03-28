package com.stackroute.adminservice.service;

import com.stackroute.adminservice.domain.Program;

import java.util.List;

public interface ProgramService {
    Program saveProgram(Program program);

    List<Program> getAllPrograms();

    Program updateProgram(Program program);

    void deleteProgram(String programId);
}
