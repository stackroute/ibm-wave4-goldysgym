package com.stackroute.adminservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Document("program")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
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
    @NotNull
    private String trainerName;
    @NotNull
    private String trainerDescription;
    @NotNull
    private int totalSeats;

    public Program() {
    }

    public Program(String programId, @NotNull String programName, @NotNull String day, @NotNull String timing, @NotNull String imageUrl, @NotNull String programDescription, @NotNull String trainerName, @NotNull String trainerDescription, @NotNull int totalSeats) {
        this.programId = programId;
        this.programName = programName;
        this.day = day;
        this.timing = timing;
        this.imageUrl = imageUrl;
        this.programDescription = programDescription;
        this.trainerName = trainerName;
        this.trainerDescription = trainerDescription;
        this.totalSeats = totalSeats;

    }
    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProgramDescription() {
        return programDescription;
    }

    public void setProgramDescription(String programDescription) {
        this.programDescription = programDescription;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getTrainerDescription() {
        return trainerDescription;
    }

    public void setTrainerDescription(String trainerDescription) {
        this.trainerDescription = trainerDescription;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }
}

