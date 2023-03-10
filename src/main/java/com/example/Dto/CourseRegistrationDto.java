package com.example.Dto;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
public class CourseRegistrationDto {
    Integer student;
    Integer course;
    LocalDateTime registeredAt;
}
