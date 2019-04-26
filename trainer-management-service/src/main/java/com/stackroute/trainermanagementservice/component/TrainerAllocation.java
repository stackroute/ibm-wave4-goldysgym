package com.stackroute.trainermanagementservice.component;

import com.stackroute.trainermanagementservice.domain.ProgramDto;
import com.stackroute.trainermanagementservice.domain.Trainer;
import com.stackroute.trainermanagementservice.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class TrainerAllocation {

    private TrainerService trainerService;


    @Autowired
    public TrainerAllocation(TrainerService trainerService) {
        this.trainerService = trainerService;

    }

    public void allocation(ProgramDto programDto) {

        int countProgramtype = 0;
        List<Trainer> trainerList = trainerService.getAllTrainer();
        for (Trainer trainer : trainerList) {
            List<String> programs = trainer.getProgramType();
            for (String programType : programs) {
                if (programType.equals(programDto.getProgram()) && trainer.isAvailability() == true) {

                    countProgramtype++;
                    if (countProgramtype == 1) {
                        trainer.setAvailability(false);
                        System.out.println(trainer.isAvailability());
                        trainer.setProgramDto(programDto);

                        trainerService.saveTrainer(trainer);
                        System.out.println(trainer.toString());
                        break;

                    }


                }

            }

        }

    }
}




