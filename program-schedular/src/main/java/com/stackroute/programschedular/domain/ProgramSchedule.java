package com.stackroute.programschedular.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class ProgramSchedule {
  String userId;
  List<WeekSchedule> weekSchedule;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public List<WeekSchedule> getWeekSchedule() {
    return weekSchedule;
  }

  public void setWeekSchedule(List<WeekSchedule> weekSchedule) {
    this.weekSchedule = weekSchedule;
  }
}

