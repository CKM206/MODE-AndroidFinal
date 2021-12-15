package com.example.androidfinal.Models;

public abstract class Employee {

    private int employeeID;
    private String firstName;
    private String lastName;
    private int birthYear;

    public Vehicle vref;

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public Employee(int employeeID, String firstName, String lastName, int birthYear) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        vref = null;
    }

    public Employee() {
        this.employeeID = -1;
        this.firstName = "";
        this.lastName = "";
        this.birthYear = 0;
        vref = null;
    }

    public Employee(int employeeID, String firstName, String lastName, int birthYear, Vehicle vref) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.vref = vref;
    }

    public abstract int calcEarnings();

    public int calcAge() {
        return 2021 - this.birthYear;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID='" + employeeID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }
}
