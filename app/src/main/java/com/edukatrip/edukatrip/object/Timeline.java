package com.edukatrip.edukatrip.object;

import java.util.Date;

public class Timeline {
    private Date startTime;
    private Date endTime;
    private Places destination;
    private String description;

    public Timeline(Date startTime, Date endTime, Places destination, String description) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.destination = destination;
        this.description = description;
    }

    public Timeline(Date startTime, Date endTime, Places destination) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.destination = destination;
        this.description = destination.getDescription();
    }




    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Places getDestination() {
        return destination;
    }

    public void setDestination(Places destination) {
        this.destination = destination;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
