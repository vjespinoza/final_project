package com.globant.university.data;

import java.util.List;

public interface SearchCourses {
    public List<Course> getAssociatedCourses(String studentId, List<Course> courses);
}