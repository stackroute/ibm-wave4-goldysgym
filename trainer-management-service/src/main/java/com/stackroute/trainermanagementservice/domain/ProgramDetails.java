package com.stackroute.trainermanagementservice.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class ProgramDetails {
    private String programId;
    private String programName;
    private String day;
    private String slot;

}
