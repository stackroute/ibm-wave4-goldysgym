package com.stackroute.programschedular.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Monday {
    Morning morning;
    Evening evening;

    public Monday() {
    }

    public Morning getMorning() {
        return morning;
    }

    public void setMorning(Morning morning) {
        this.morning = morning;
    }

    public Evening getEvening() {
        return evening;
    }

    public void setEvening(Evening evening) {
        this.evening = evening;
    }
}
