package com.example.Dto;

import com.example.Model.CourseDao;
import com.example.Model.CourseRegistrationDao;
import com.example.Model.StudentDao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class CourseRegistrationResponseDto {
    Integer id;
    StudentResponseDto student;
    CourseResponseDto course;
    LocalDateTime registeredAt;


    public CourseRegistrationResponseDto(CourseRegistrationDao courseRegistrationDao){
        this.id = courseRegistrationDao.getId();
        this.student = new StudentResponseDto(courseRegistrationDao.getStudent());
        this.course = new CourseResponseDto(courseRegistrationDao.getCourse());
        this.registeredAt = courseRegistrationDao.getRegisteredAt();
    }
}
