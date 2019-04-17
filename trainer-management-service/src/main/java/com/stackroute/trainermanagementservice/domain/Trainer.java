package com.stackroute.trainermanagementservice.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class Trainer {
    private String trainerid;
    private String trainername;
    private String imageUrl;
    private List<String> programType;
    private String description;
    private boolean availability;
    private List<Program> program;

}