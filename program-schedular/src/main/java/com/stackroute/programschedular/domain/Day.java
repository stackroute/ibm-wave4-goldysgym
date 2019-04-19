package com.stackroute.programschedular.domain;


import java.util.Date;

public class Day {
    String date;
    Slots[] slots = new Slots[3];

    public Day() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Slots[] getSlots() {
        return slots;
    }

    public void setSlots(Slots[] slots) {
        this.slots = slots;
    }
}
