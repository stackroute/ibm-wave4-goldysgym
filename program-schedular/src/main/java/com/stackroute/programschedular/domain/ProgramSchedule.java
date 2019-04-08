package com.stackroute.programschedular.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ProgramSchedule {
  String userId;
  WeekSchedule weekSchedule;
}
