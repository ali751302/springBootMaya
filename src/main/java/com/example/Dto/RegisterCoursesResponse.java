package com.example.Dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class RegisterCoursesResponse {
    String studentName;
    String registrationNo;
    List<RegisterCourse> courses;

    public void addCourse(RegisterCourse course){
        this.courses.add(course);
    }
}
