package com.globant.university.data.professor;

import com.globant.university.data.Course;
import com.globant.university.data.SearchCourses;

import java.util.ArrayList;
import java.util.List;

public abstract class Professor implements SearchCourses {
    private static int counter = 1;
    protected String professorID;
    protected String firstName;
    protected String lastName;
    protected static float baseSalary = 1500;


    public Professor(String firstName, String lastName) {
        this.professorID = "PF" + String.format("%03d", counter++);
        this.firstName = (firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase());
        this.lastName = (lastName.substring(0,1).toUpperCase() + lastName.substring(1).toLowerCase());
    }

    public abstract float calculateSalary();

    @Override
    public List<Course> getAssociatedCourses(String professorId, List<Course> courses) {
        List<Course> professorCourses = new ArrayList<>();
        for (Course c : courses) {
            if (professorId.equals(c.getProfessor().getProfessorID())) {
                professorCourses.add(c);
            }
        }
        return professorCourses;
    }

    public String getProfessorID() {
        return professorID;
    }

    public void setProfessorID(String professorID) {
        this.professorID = professorID;
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

    public float getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(float baseSalary) {
        Professor.baseSalary = baseSalary;
    }

}
