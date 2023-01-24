package com.example.Dto;

import com.example.Model.CourseDao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CourseResponseDto {
    Integer id;
    String courseCode;
    String courseName;
    Float creditHours;

    public CourseResponseDto(CourseDao courseDao) {
        this.id = courseDao.getId();
        this.courseCode = courseDao.getCourseCode();
        this.courseName = courseDao.getCourseName();
        this.creditHours = courseDao.getCreditHours();
    }

}
