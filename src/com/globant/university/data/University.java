package com.globant.university.data;

import com.globant.university.data.professor.FullTimeProfessor;
import com.globant.university.data.professor.PartTimeProfessor;
import com.globant.university.data.professor.Professor;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String universityName = "TAE University";
    private List<Professor> professors = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    public void hireNewProfessor(String fName, String lName, boolean isFullTime, int experience, int hours) {
        Professor newProfessor;
        if (isFullTime) {
            newProfessor = new FullTimeProfessor(fName, lName, experience);
        } else {
            newProfessor = new PartTimeProfessor(fName, lName, hours);
        }
        professors.add(newProfessor);
    }

    public Student enrollNewStudent(String fName, String lName, String birthDate) {
        Student newStudent = new Student(fName, lName, birthDate);
        students.add(newStudent);
        return newStudent;
    }


    public void createNewCourse(String name, String classRoom, List<Student> students, Professor professor) {
        Course newCourse = new Course(name, classRoom, students, professor);
        courses.add(newCourse);
    }

    public boolean removeProfessor(String ID) {
        return this.professors.removeIf(p -> ID.equals(p.getProfessorID()));
    }

    public boolean removeStudent(String ID) {
        return this.students.removeIf(s -> ID.equals(s.getStudentID()));
    }

    public boolean removeCourse(String ID) {
        return this.courses.removeIf(c -> ID.equals(c.getCourseID()));
    }

    public Professor findProfessorByID(String ID) {
        Professor foundProfessor = null;
        for (Professor professor : this.professors) {
            if (ID.equals(professor.getProfessorID())) {
                foundProfessor = professor;
            }
        }
        return foundProfessor;
    }

    public Student findStudentByID(String ID) {
        Student foundStudent = null;
        for (Student student : this.students) {
            if (ID.equals(student.getStudentID())) {
                foundStudent = student;
            }
        }
        return foundStudent;
    }

    public Course findCourseByID(String ID) {
        Course foundCourse = null;
        for (Course course : this.courses) {
            if (ID.equals(course.getCourseID())) {
                foundCourse = course;
            }
        }
        return foundCourse;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
