package com.example.demoaopjava.entity;

import com.example.demoaopjava.annotation.DateFormat;

public class Ticket {
    @DateFormat
    private String startDate;

    @DateFormat(value = "yyyy/MM/dd HH:mm:ss")
    private String endDate;

    public String getEndDate() {
        return endDate;
    }

    public Ticket() {}


    public Ticket(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }


    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
