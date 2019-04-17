package com.stackroute.trainermanagementservice.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class Program {
    private String programid;
    private String programname;
    private String day;
    private String slot;

}
