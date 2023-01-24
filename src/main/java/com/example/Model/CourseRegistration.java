package com.example.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "course_registration")
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

    int grade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudentDao getStudent() {
        return student;
    }

    public void setStudent(StudentDao student) {
        this.student = student;
    }

    public CourseDao getCourse() {
        return course;
    }

    public void setCourse(CourseDao course) {
        this.course = course;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
