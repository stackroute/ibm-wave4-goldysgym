package com.stackroute.trainermanagementservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Program {


    @NotNull
    private String programId;
    @NotNull
    private String programName;
    @NotNull
    private String day;
    @NotNull
    private String timing;
    @NotNull
    private String imageUrl;
    @NotNull
    private String programDescription;
    private String trainerName;
    private String trainerId;
    @NotNull
    private String trainerDescription;
    @NotNull
    private int totalSeats;

}


