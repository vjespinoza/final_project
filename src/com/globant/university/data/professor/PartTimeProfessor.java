package com.globant.university.data.professor;

import java.text.NumberFormat;

public class PartTimeProfessor extends Professor {
    protected int hoursPerWeek;
    protected static String dedication = "Part Time";

    public PartTimeProfessor(String firstName, String lastName, int hoursPerWeek) {
        super(firstName, lastName);
        this.hoursPerWeek = hoursPerWeek;
    }

    public float calculateSalary() {
        return (baseSalary * hoursPerWeek);
    };

    @Override
    public String toString() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return  "Professor ID: " + professorID + '\n' +
                "Professor Name: " + lastName + ", " + firstName + '\n' +
                "Dedication: " + dedication + '\n' +
                "Active hours per Week: " + hoursPerWeek + '\n' +
                "Paid Salary: " + currency.format(calculateSalary());
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(int hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    public static String getDedication() {
        return dedication;
    }

    public static void setDedication(String dedication) {
        PartTimeProfessor.dedication = dedication;
    }
}
