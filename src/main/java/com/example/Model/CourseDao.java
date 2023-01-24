package com.example.Model;

import com.example.Dto.CourseDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "Course")
@Getter
@Setter
@NoArgsConstructor
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

}
