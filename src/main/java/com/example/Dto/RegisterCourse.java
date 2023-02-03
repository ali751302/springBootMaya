package com.example.Dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RegisterCourse {
    CourseResponseDto course;
    LocalDateTime registeredAt;
}
