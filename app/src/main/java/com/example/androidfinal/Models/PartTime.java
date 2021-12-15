package com.example.androidfinal.Models;

import android.media.Image;
import android.widget.ImageView;

import com.example.androidfinal.R;

public class PartTime extends Employee{

    private int hoursWorked;
    private int rate;

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public PartTime(int employeeID, String firstName, String lastName, int birthYear, String type, int hoursWorked, int rate) {
        super(employeeID, firstName, lastName, birthYear, type);
        this.hoursWorked = hoursWorked;
        this.rate = rate;
    }

    public PartTime() {
        super();
        this.hoursWorked = 0;
        this.rate = 0;
    }


    @Override
    public int calcEarnings() {
        return this.hoursWorked * this.rate;
    }

    @Override
    public String toString() {
        int smile = R.drawable.smile1;
        return super.toString() + ", Subtitle: Part-time " ;
    }
}
