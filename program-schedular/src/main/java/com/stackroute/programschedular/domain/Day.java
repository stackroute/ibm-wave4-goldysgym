package com.stackroute.programschedular.domain;


import java.util.Date;

public class Day {
    Date date;
    Slots[] slots = new Slots[3];

    public Day() {
    }

    public Day(Date date, Slots[] slots) {
        this.date = date;
        this.slots = slots;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Slots[] getSlots() {
        return slots;
    }

    public void setSlots(Slots[] slots) {
        this.slots = slots;
    }
}
