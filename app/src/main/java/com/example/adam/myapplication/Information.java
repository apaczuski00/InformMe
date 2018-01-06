package com.example.adam.myapplication;

/**
 * Created by adam on 04.01.18.
 */


public class Information {
    private String date;
    private String details;
    private String area;


    public Information(String date, String details, String area) {
        this.date = date;
        this.details = details;
        this.area = area;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
