package com.globant.university;

import com.globant.university.data.Course;
import com.globant.university.data.Student;
import com.globant.university.data.University;
import com.globant.university.data.professor.FullTimeProfessor;
import com.globant.university.data.professor.PartTimeProfessor;
import com.globant.university.data.professor.Professor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        University university = initializeUniversity();
        boolean exit = false;

        System.out.println("******************************");
        System.out.println(university.getUniversityName());
        System.out.println("******************************");

        while (!exit) {
            System.out.println("""
                        
                    MAIN MENU:
                    1. Manage Professors.
                    2. Manage Students.
                    3. Manage Courses.
                    4. Exit.
                    """);
            System.out.print(">>> ");
            String option = scanner.next().toLowerCase().trim();
            switch (option) {
                case "1":
                    boolean exitProfessors = false;
                    while (!exitProfessors) {
                        System.out.println("\nMANAGE PROFESSORS: ");
                        System.out.println("""
                            a. Hire new professor.
                            b. Remove professor.
                            c. Check assigned courses.
                            d. Check professors directory.
                            e. Go back.
                            """);
                        System.out.print(">>> ");
                        String input = scanner.next().toLowerCase().trim();
                        switch (input) {
                            case "a":
                                hireNewProfessor(scanner, university);
                                break;
                            case "b":
                                removeProfessor(scanner, university);
                                break;
                            case "c":
                                professorAssignedCourses(scanner, university);
                                break;
                            case "d":
                                professorsDirectory(university);
                                break;
                            case "e":
                                exitProfessors = true;
                                break;
                            default:
                                System.out.println("Enter a valid option.");
                                break;
                        }
                    }

                    break;
                case "2":
                    boolean exitStudents = false;
                    while (!exitStudents) {
                        System.out.println("\nMANAGE STUDENTS:");
                        System.out.println("""
                                a. Enroll new student.
                                b. Remove student.
                                c. Check student pool.
                                d. Check enrolled courses.
                                e. Go back.
                                """);
                        System.out.print(">>> ");
                        String input = scanner.next().toLowerCase().trim();
                        switch (input) {
                            case "a":
                                enrollNewStudent(scanner, university);
                                break;
                            case "b":
                                removeStudent(scanner, university);
                                break;
                            case "c":
                                studentsPool(university);
                                break;
                            case "d":
                                studentEnrolledCourses(scanner, university);
                                break;
                            case "e":
                                exitStudents = true;
                                break;
                            default:
                                System.out.println("Enter a valid option.");
                                break;
                        }
                    }
                    break;
                case "3":
                    boolean exitCourses = false;
                    while (!exitCourses) {
                        System.out.println("\nMANAGE COURSES:");
                        System.out.println("""
                                a. Create new course.
                                b. Remove course.
                                c. Assign new professor.
                                d. Assign new classroom
                                e. Enroll new students.
                                f. Check available courses.
                                g. Go back.
                                """);
                        System.out.print(">>> ");
                        String input = scanner.next().toLowerCase().trim();
                        switch (input) {
                            case "a":
                                createNewCourse(scanner, university);
                                break;
                            case "b":
                                removeCourse(scanner, university);
                                break;
                            case "c":
                                assignNewCourseProfessor(scanner, university);
                                break;
                            case "d":
                                assignNewCourseClassroom(scanner, university);
                                break;
                            case "e":
                                enrollNewCourseStudents(scanner, university);
                                break;
                            case "f" :
                                availableCourses(scanner, university);
                                break;
                            case "g":
                                exitCourses = true;
                                break;
                            default:
                                System.out.println("Enter a valid option.");
                                break;
                        }
                    }
                    break;
                case "4":
                    exit = true;
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Please type a valid option");
                    break;

            }

        }

    }

    public static University initializeUniversity() {
        University university = new University();

        Professor professor1 = new FullTimeProfessor( "Till", "Lindemann",25);
        Professor professor2 = new FullTimeProfessor( "Jonathan", "Davis",18);
        Professor professor3 = new PartTimeProfessor( "Dave", "Grohl",40);
        Professor professor4 = new PartTimeProfessor( "Zack", "De la Rocha",45);

        List<Professor> initProfessors = Arrays.asList(professor1, professor2, professor3, professor4);

        Student student1 = new Student("Maria", "Brink", "12/5/2001");
        Student student2 = new Student("Kurt", "Cobain", "21/8/1999");
        Student student3 = new Student("James", "Hetfield", "16/5/1998");
        Student student4 = new Student("Dolores", "O'Riordan", "28/1/2002");
        Student student5 = new Student("Anthony", "Kiedis", "4/11/2003");
        Student student6 = new Student("Janis", "Joplin", "31/12/2000");

        List<Student> initStudents = Arrays.asList(student1, student2, student3, student4, student5, student6);

        Course course1 =  new Course( "Biology",  "CR001", Arrays.asList(student4, student1, student6), professor2);
        Course course2 =  new Course( "History",  "CR002", Arrays.asList(student3, student5, student1), professor4);
        Course course3 =  new Course( "Math",  "CR003", Arrays.asList(student6, student3, student4), professor3);
        Course course4 =  new Course( "Geography",  "CR004", Arrays.asList(student4, student5, student2), professor1);

        List<Course> initCourses = Arrays.asList(course1, course2, course3, course4);

        university.getProfessors().addAll(initProfessors);
        university.getStudents().addAll(initStudents);
        university.getCourses().addAll(initCourses);

        return university;
    }

    public static void printProfessorMenu(List<Professor> professors) {
        for (Professor p : professors) {
            System.out.println("\t* " + p .getProfessorID() + " - " + p.getLastName() + ", " + p.getFirstName() );
        }
    }

    public static void printStudentMenu(List<Student> students) {
        for (Student s : students) {
            System.out.println("\t* " + s.getStudentID() + " - " + s.getLastName() + ", " + s.getFirstName());
        }
    }

    public static void printCourseMenu(List<Course> courses) {
        for (Course c : courses) {
            System.out.println("\t* " + c.getCourseID() + " - " + c.getCourseName());
        }
    }

    public static boolean checkValidDate(String date) {
        String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(date);
        return match.matches();
    }

    public static void hireNewProfessor(Scanner scanner, University university) {
        System.out.println("HIRE NEW PROFESSOR");
        System.out.println("******************************\n");
        System.out.println("Enter first name: ");
        if (scanner.hasNextLine()) scanner.nextLine();
        String fName = scanner.nextLine().trim().toLowerCase();
        System.out.println("\nEnter last name: ");
        String lName = scanner.nextLine().trim().toLowerCase();
        System.out.println("\nSelect dedication: \n1. Full Time.\n2. Part Time");
        boolean isFullTime = scanner.nextInt() == 1;
        System.out.println("\nYears of experience: ");
        int experienceYears = scanner.nextInt();
        System.out.println("\nWeekly hours: ");
        int weeklyHours = scanner.nextInt();
        university.hireNewProfessor(fName, lName, isFullTime, experienceYears, weeklyHours);
        System.out.println("\nTAE University welcomes professor " + lName + ", " + fName);
    }
    public static void removeProfessor(Scanner scanner, University university) {
        System.out.println("REMOVE PROFESSOR");
        System.out.println("******************************\n");
        System.out.println("Type professor's ID: ");
        printProfessorMenu(university.getProfessors());
        System.out.print(">>> ");
        String targetID = scanner.next().toUpperCase().trim();
        if (university.removeProfessor(targetID)) {
            System.out.println("Professor " + targetID + " was removed");
        } else {
            System.out.println("Professor " + targetID + " not found");
        }
    }
    public static void professorAssignedCourses(Scanner scanner, University university) {
        System.out.println("ASSIGNED COURSES BY PROFESSOR");
        System.out.println("******************************\n");
        boolean isValidProfessor = false;
        Professor targetProfessor = null;
        String professorID = "";
        while (!isValidProfessor) {
            System.out.println("Type professor's ID: ");
            printProfessorMenu(university.getProfessors());
            System.out.print(">>> ");
            professorID = scanner.next().toUpperCase().trim();
            targetProfessor = university.findProfessorByID(professorID);
            if (targetProfessor == null) {
                System.out.println("Professor " + professorID + " not found\n");
            } else {
                isValidProfessor = true;
            }
        }
        List<Course> courses = targetProfessor.getAssociatedCourses(targetProfessor.getProfessorID(), university.getCourses());
        if (courses.size() > 0) {
            System.out.println("\nProfessor " + professorID + " assigned courses:");
            for (Course course : courses ) {
                System.out.println("\t* " + course.getCourseID() + " - " + course.getCourseName());
            }
        } else {
            System.out.println("Professor " + professorID + " does not have assigned courses");
        }
    }
    public static void professorsDirectory(University university) {
        System.out.println("PROFESSORS DIRECTORY");
        System.out.println("******************************\n");
        for (Professor p : university.getProfessors()) {
            System.out.println(p.toString());
            System.out.println("******************************\n");
        }
    }
    public static void enrollNewStudent(Scanner scanner, University university) {
        System.out.println("ENROLL NEW STUDENT");
        System.out.println("******************************");
        Student newStudent = null;
        System.out.println("\nEnter first name: ");
        if (scanner.hasNextLine()) scanner.nextLine();
        String fName = scanner.nextLine().trim().toLowerCase();
        System.out.println("\nEnter last name: ");
        String lName = scanner.nextLine().trim().toLowerCase();
        boolean validDate = false;
        while (!validDate) {
            System.out.println("\nEnter date of birth [DD/MM/YYYY]: ");
            String birthdate = scanner.next().trim();
            boolean isValidDate = checkValidDate(birthdate);
            if (isValidDate) {
                newStudent = university.enrollNewStudent(fName, lName, birthdate);
                validDate = true;
            } else {
                System.out.println("Please check birthdate format [DD/MM/YYYY]\n");
            }
        }
        System.out.println("\nType course's ID for enrollment: ");
        boolean finishEnrollment = false;
        while (!finishEnrollment) {
            printCourseMenu(university.getCourses());
            System.out.println("\nConfirm and go back [Y]");
            System.out.print(">>> ");
            String courseID = scanner.next().toUpperCase().trim();
            finishEnrollment = courseID.equals("Y");
            Course foundCourse = university.findCourseByID(courseID);
            if (foundCourse == null) {
                System.out.println("Unable to find course");
            } else {
                List<Student> studentList = new ArrayList<>(foundCourse.getCourseStudents());
                studentList.add(newStudent);
                foundCourse.setCourseStudents(studentList);
                System.out.println("Student enrolled to course " + courseID + "\n");
            }
        }
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println("New student enrolled successfully");
        System.out.println("\n>>> Student ID: " + newStudent.getStudentID());
        System.out.println(">>> Name: " + newStudent.getLastName() + ", " + newStudent.getFirstName());
        System.out.println("\nWelcome to TAE University!");
        System.out.println("++++++++++++++++++++++++++++++");
    }
    public static void removeStudent(Scanner scanner, University university) {
        System.out.println("REMOVE STUDENT");
        System.out.println("******************************\n");
        System.out.println("Type student's ID: ");
        printStudentMenu(university.getStudents());
        System.out.print(">>> ");
        String targetID = scanner.next().toUpperCase().trim();
        if (university.removeStudent(targetID)) {
            System.out.println("Student " + targetID + " was removed");
        } else {
            System.out.println("Student " + targetID + " not found");
        }
    }
    public static void studentsPool(University university) {
        System.out.println("STUDENT POOL");
        System.out.println("******************************\n");
        for (Student s : university.getStudents()) {
            System.out.println(s.toString());
            System.out.println("******************************\n");
        }
    }
    public static void studentEnrolledCourses(Scanner scanner, University university) {
        System.out.println("ENROLLED COURSES BY STUDENT");
        System.out.println("******************************\n");
        System.out.println("Enter student ID:");
        printStudentMenu(university.getStudents());
        System.out.print(">>> ");
        String studentID = scanner.next().toUpperCase().trim();
        Student targetStudent = university.findStudentByID(studentID);
        if (targetStudent == null) {
            System.out.println("\nStudent " + studentID + " not found");
        } else {
            System.out.println("\nStudent " + studentID + " enrolled courses:");
            List<Course> studentCourses = targetStudent.getAssociatedCourses(studentID, university.getCourses());
            for (Course c : studentCourses) {
                System.out.println("\t* " + c.getCourseID() + " - " + c.getCourseName());
            }
        }
    }
    public static void createNewCourse(Scanner scanner, University university) {
        System.out.println("CREATE NEW COURSE");
        System.out.println("******************************\n");
        System.out.println("Enter course name: ");
        if (scanner.hasNextLine()) scanner.nextLine();
        String courseName = scanner.nextLine().trim().toLowerCase();
        System.out.println("\nEnter classroom ID: ");
        String classroom = scanner.next().toUpperCase().trim();
        System.out.println("Enroll students:");
        List<Student> courseStudents = new ArrayList<>();
        boolean goBack = false;
        while (!goBack) {
            System.out.println("\nType student's ID");
            printStudentMenu(university.getStudents());
            System.out.println("\nConfirm and go back [Y]");
            System.out.print(">>> ");
            String studentID = scanner.next().toUpperCase().trim();
            goBack = studentID.equals("Y");
            Student student = university.findStudentByID(studentID);
            if (student == null && !goBack) {
                System.out.println("\nUnable to find student ID\n");
            } else if (!goBack) {
                System.out.println("\nStudent " + student.getStudentID() + " enrolled successfully\n");
                courseStudents.add(student);
            }
        }
        System.out.println("\nType professor's ID to assign course: ");
        printProfessorMenu(university.getProfessors());
        System.out.print(">>> ");
        String professorID = scanner.next().toUpperCase().trim();
        Professor professor = university.findProfessorByID(professorID);
        if (professor == null) {
            System.out.println("\nUnable to find professor ID");
        } else {
            System.out.println("\nProfessor " + professorID + " assigned to this course.");
            university.createNewCourse(courseName, classroom, courseStudents, professor);
        }
        System.out.println("\nCourse " + courseName + " was created successfully");
    }
    public static void removeCourse(Scanner scanner, University university) {
        System.out.println("REMOVE COURSE");
        System.out.println("******************************\n");
        System.out.println("Type course's ID: ");
        printCourseMenu(university.getCourses());
        System.out.print(">>> ");
        String targetID = scanner.next().toUpperCase().trim();
        if (university.removeCourse(targetID)) {
            System.out.println("Course " + targetID + " was removed");
        } else {
            System.out.println("Course " + targetID + " not found");
        }
    }
    public static void assignNewCourseProfessor(Scanner scanner, University university) {
        System.out.println("ASSIGN NEW COURSE PROFESSOR");
        System.out.println("******************************\n");
        Course courseMatch = null;
        while (courseMatch == null) {
            System.out.println("Type course's ID: ");
            printCourseMenu(university.getCourses());
            System.out.print(">>> ");
            String courseID = scanner.next().toUpperCase().trim();
            courseMatch = university.findCourseByID(courseID);
            if (courseMatch == null)
                System.out.println("Course " + courseID + " not found\n");
        }
        Professor professorMatch = null;
        while (professorMatch == null) {
            System.out.println("Type professor's ID: ");
            printProfessorMenu(university.getProfessors());
            System.out.print(">>> ");
            String professorSelect = scanner.next().toUpperCase().trim();
            professorMatch = university.findProfessorByID(professorSelect);
            if (professorMatch == null)
                System.out.println("Professor " + professorSelect + " not found\n");
        }
        courseMatch.setProfessor(professorMatch);
        System.out.println(courseMatch.getCourseName() + " has been assigned to" +
                "\nprofessor " + professorMatch.getProfessorID() + " - " + professorMatch.getLastName() + ", " + professorMatch.getFirstName());
    }
    public static void assignNewCourseClassroom(Scanner scanner, University university) {
        System.out.println("ASSIGN NEW COURSE CLASSROOM");
        System.out.println("******************************\n");
        Course courseSearch = null;
        while (courseSearch == null) {
            System.out.println("Type course's ID: ");
            printCourseMenu(university.getCourses());
            System.out.print(">>> ");
            String courseID = scanner.next().toUpperCase().trim();
            courseSearch = university.findCourseByID(courseID);
            if (courseSearch == null)
                System.out.println("Course " + courseID + " not found\n");
        }
        System.out.println("Type classroom ID:");
        System.out.print(">>> ");
        String classroomID = scanner.next().toUpperCase().trim();
        courseSearch.setClassRoom(classroomID);
        System.out.println(courseSearch.getCourseName() + " has been assigned to" +
                "\nclassroom " + classroomID);
    }
    public static void enrollNewCourseStudents(Scanner scanner, University university) {
        System.out.println("ENROLL COURSE NEW STUDENT");
        System.out.println("******************************\n");
        Course courseLookUp = null;
        while (courseLookUp == null) {
            System.out.println("Type course's ID: ");
            printCourseMenu(university.getCourses());
            System.out.print(">>> ");
            String courseID = scanner.next().toUpperCase().trim();
            courseLookUp = university.findCourseByID(courseID);
            if (courseLookUp == null)
                System.out.println("Course " + courseID + " not found\n");
        }
        boolean confirmStudents = false;
        List<Student> enrolledStudents = new ArrayList<>(courseLookUp.getCourseStudents());
        while (!confirmStudents) {
            System.out.println("Type student's ID: ");
            printStudentMenu(university.getStudents());
            System.out.println("\nConfirm and go back [Y]");
            System.out.print(">>> ");
            String studentID = scanner.next().toUpperCase().trim();
            confirmStudents = studentID.equals("Y");
            Student student = university.findStudentByID(studentID);
            if (student == null && !studentID.equals("Y")) {
                System.out.println("Student " + studentID + " not found");
            } else if (!studentID.equals("Y")) {
                enrolledStudents.add(student);
            }
        }
        courseLookUp.setCourseStudents(enrolledStudents);
        System.out.println("Students enrolled to the " + courseLookUp.getCourseName() + " course:");
        enrolledStudents.forEach(s ->
                System.out.println("\t* " + s.getStudentID() + " - " + s.getLastName() + ", " + s.getFirstName())
        );
    }
    public static void availableCourses(Scanner scanner, University university) {
        System.out.println("AVAILABLE COURSES");
        System.out.println("******************************\n");
        System.out.println("Type course's ID for more info.");
        printCourseMenu(university.getCourses());
        System.out.println("\nGo back [Y]");
        System.out.print(">>> ");
        String courseID = scanner.next().toUpperCase().trim();
        boolean goBack = courseID.equals("Y");
        Course foundCourse = university.findCourseByID(courseID);
        if (foundCourse == null && !goBack) {
            System.out.println("Enter a valid ID");
        } else if (!goBack){
            System.out.println(foundCourse);
            for (Student s : foundCourse.getCourseStudents()) {
                System.out.println("\t* " + s.getStudentID() + " - " + s.getLastName() + ", " + s.getLastName());

            }

        }
    }




}
