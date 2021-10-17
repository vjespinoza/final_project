package com.globant.university.data.professor;

import java.text.NumberFormat;

public class FullTimeProfessor extends Professor{
    protected int experienceYears;
    protected static String dedication = "Full Time";

    public FullTimeProfessor(String firstName, String lastName, int experienceYears) {
        super(firstName, lastName);
        this.experienceYears = experienceYears;
    }

    public float calculateSalary() {
        final float basePercentage = 1.1F;
        return (baseSalary * (experienceYears * basePercentage));
    }

    @Override
    public String toString() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return  "Professor ID: " + professorID + '\n' +
                "Professor Name: " + lastName + ", " + firstName + '\n' +
                "Dedication: " + dedication + '\n' +
                "Experience Years: " + experienceYears + '\n' +
                "Paid Salary: " + currency.format(calculateSalary());
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public static String getDedication() {
        return dedication;
    }

    public static void setDedication(String dedication) {
        FullTimeProfessor.dedication = dedication;
    }
}
