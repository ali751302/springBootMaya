package com.example.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "course_registration")
@Getter
@Setter
public class CourseRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    StudentDao student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    CourseDao course;

    LocalDateTime registeredAt;
}
