package com.example.Dto;

import com.example.Model.CourseDao;

public class CourseResponseDto {
    Integer id;
    String courseCode;
    String courseName;
    Float creditHours;

    public CourseResponseDto() {
    }

    public CourseResponseDto(CourseDao courseDao) {
        this.id = courseDao.getId();
        this.courseCode = courseDao.getCourseCode();
        this.courseName = courseDao.getCourseName();
        this.creditHours = courseDao.getCreditHours();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
