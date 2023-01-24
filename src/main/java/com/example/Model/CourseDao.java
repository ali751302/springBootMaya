package com.example.Model;

import com.example.Dto.CourseDto;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Course")
public class CourseDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    Integer id;
    String courseCode;
    String courseName;
    Float creditHours;
    @OneToMany(mappedBy = "course")
    Set<CourseRegistration> registrations;

    public CourseDao(CourseDto courseDto) {
        this.courseCode=courseDto.getCourseCode();
        this.courseName = courseDto.getCourseName();
        this.creditHours = courseDto.getCreditHours();
    }

    public Set<CourseRegistration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Set<CourseRegistration> registrations) {
        this.registrations = registrations;
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
