package com.example.Dto;

public class CourseDto {
    String courseCode;
    String courseName;
    Float creditHours;

    public CourseDto() {
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Float getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(Float creditHours) {
        this.creditHours = creditHours;
    }
}

