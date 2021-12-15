package com.example.androidfinal.Models;

public class FullTime extends Employee{

    private int salary;
    private int bonus;


    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }


    public FullTime(int employeeID, String firstName, String lastName, int birthYear, int salary, int bonus) {
        super(employeeID, firstName, lastName, birthYear);
        this.salary = salary;
        this.bonus = bonus;
    }

    public FullTime() {
        super();
        this.salary = 0;
        this.bonus = 0;
    }

    @Override
    public int calcEarnings() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + " FullTime{" +
                "salary=" + salary +
                ", bonus=" + bonus +
                '}';
    }
}
