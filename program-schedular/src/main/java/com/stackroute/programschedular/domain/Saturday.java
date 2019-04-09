package com.stackroute.programschedular.domain;

public class Saturday {
    Morning morning;
    Evening evening;



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
