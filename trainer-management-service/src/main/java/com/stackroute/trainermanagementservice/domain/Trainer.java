package com.stackroute.trainermanagementservice.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class Trainer {
    @Id
    private String trainerId;
    private String trainerName;
    private String trainerDescription;
    private String imageUrl;
    private List<String> programType;
    private boolean availability;
    private ProgramDto programDto;

}