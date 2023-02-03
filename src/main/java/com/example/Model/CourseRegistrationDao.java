package com.example.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "course_registration")
@Getter
@Setter
@NoArgsConstructor
public class CourseRegistrationDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    StudentDao student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    CourseDao course;

    LocalDateTime registeredAt;

    public CourseRegistrationDao(StudentDao studentDao, CourseDao courseDao, LocalDateTime now) {
        this.student = studentDao;
        this.course = courseDao;
        this.registeredAt = now;
    }

}
