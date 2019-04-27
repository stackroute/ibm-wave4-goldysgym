package com.stackroute.springbootneo4jCRUD.domain;

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

    @Id
    private String programId;
    @NotNull
    private String programName;
    @NotNull
    private String imageUrl;
    @NotNull
    private String programDescription;


}

