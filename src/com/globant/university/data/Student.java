package com.globant.university.data;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Student implements SearchCourses {
    private static int counter = 1;
    private String studentID;
    private String firstName;
    private String lastName;
    private String dateOfBirth;

    public Student(String firstName, String lastName, String dateOfBirth) {
        this.studentID = "ST" + String.format("%03d", counter++);
        this.firstName = (firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase());
        this.lastName = (lastName.substring(0,1).toUpperCase() + lastName.substring(1).toLowerCase());
        this.dateOfBirth = dateOfBirth;
    }

    public int calculateAge() {
        String[] dateParts = this.dateOfBirth.split("/");
        int year = Integer.parseInt(dateParts[2]);
        int month = Integer.parseInt(dateParts[1]);
        int day = Integer.parseInt(dateParts[0]);
        LocalDate birthDay = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();

        return Period.between(birthDay, today).getYears();

    }

    @Override
    public List<Course> getAssociatedCourses(String studentId, List<Course> courses) {
        List<Course> studentCourses = new ArrayList<>();
        for (Course c : courses) {
            for (Student s : c.getCourseStudents()) {
                if (studentId.equals(s.getStudentID())) {
                    studentCourses.add(c);
                }
            }
        }
        return studentCourses;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + '\n' +
                "Student Name: " + lastName + ", " + firstName + '\n' +
                "Date of Birth: " + dateOfBirth + '\n' +
                "Age: " + calculateAge();
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
