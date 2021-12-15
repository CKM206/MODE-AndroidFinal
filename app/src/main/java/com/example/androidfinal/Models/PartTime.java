package com.example.androidfinal.Models;

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
        return super.toString() + " PartTime{" +
                "hoursWorked=" + hoursWorked +
                ", rate=" + rate +
                '}';
    }
}
