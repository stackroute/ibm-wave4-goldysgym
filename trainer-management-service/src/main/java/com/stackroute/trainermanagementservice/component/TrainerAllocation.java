package com.stackroute.trainermanagementservice.component;

import com.stackroute.trainermanagementservice.controller.TrainerController;
import com.stackroute.trainermanagementservice.domain.Program;
import com.stackroute.trainermanagementservice.domain.ProgramDetails;
import com.stackroute.trainermanagementservice.domain.Trainer;
import com.stackroute.trainermanagementservice.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class TrainerAllocation {

    private TrainerService trainerService;
    private RabbitProducer rabbitProducer;


    @Autowired
    public TrainerAllocation(TrainerService trainerService,RabbitProducer rabbitProducer) {
        this.trainerService = trainerService;
        this.rabbitProducer=rabbitProducer;
    }

    public void allocation(Program program) {

        int countProgramtype = 0;
        List<Trainer> trainerList = trainerService.getAllTrainer();
        ProgramDetails programDetails = new ProgramDetails();
        for (Trainer trainer : trainerList) {
            List<String> programs = trainer.getProgramType();
            for (String programType : programs) {
                if (programType.equals(program.getProgramName()) && trainer.isAvailability() == true) {

                    countProgramtype++;
                    if (countProgramtype == 1) {
                        trainer.setAvailability(false);
                        System.out.println(trainer.isAvailability());
                        program.setTrainerId(trainer.getTrainerId());
                        program.setTrainerName(trainer.getTrainerName());
                        program.setTrainerDescription(trainer.getTrainerDescription());
                        programDetails.setDay(program.getDay());
                        programDetails.setProgramId(program.getProgramId());
                        programDetails.setProgramName(program.getProgramName());
                        programDetails.setSlot(program.getTiming());
                        trainer.setProgramDetails(programDetails);
                        System.out.println(program.getProgramName() + ":" + trainer.getTrainerName());
                        trainerService.saveTrainer(trainer);
                        System.out.println(program.toString());
                        rabbitProducer.produce(program);
                        break;

                    }


                }

            }

        }

    }
}




