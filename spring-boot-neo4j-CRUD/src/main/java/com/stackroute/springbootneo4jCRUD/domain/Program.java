package com.stackroute.springbootneo4jCRUD.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Program {

    @Id
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
    private String trainerId;
    private String trainerName;
    private String trainerDescription;
    @NotNull
    private int totalSeats;


}

