package com.globant.university.data;

import com.globant.university.data.professor.Professor;

import java.util.List;

public class Course {
    private static int counter = 1;
    private String courseID;
    private String courseName;
    private String classRoom;
    private List<Student> courseStudents;
    private Professor professor;

    public Course( String courseName, String classRoom, List<Student> courseStudents, Professor professor) {
        this.courseID = courseName.substring(0,1).toUpperCase() + String.format("%03d", counter++);
        this.courseName = (courseName.substring(0,1).toUpperCase() + courseName.substring(1).toLowerCase());
        this.classRoom = classRoom;
        this.courseStudents = courseStudents;
        this.professor = professor;
    }

    @Override
    public String toString() {
        return  "Course ID: " + courseID + '\n' +
                "Course Name: " + courseName + '\n' +
                "Classroom: " + classRoom + '\n' +
                "Professor: " + professor.getProfessorID() + " - " + professor.getLastName() + ", " + professor.getFirstName() + '\n' +
                "Course Students: " ;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public List<Student> getCourseStudents() {
        return courseStudents;
    }

    public void setCourseStudents(List<Student> courseStudents) {
        this.courseStudents = courseStudents;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
