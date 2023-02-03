package com.example.Model;

import com.example.Dto.StudentDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "Student")
@Getter
@Setter
@NoArgsConstructor
public class StudentDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    Integer id;
    String registration;
    String fName;
    String lName;
    String email;
    @OneToMany(mappedBy = "student")
    Set<CourseRegistrationDao> registrations;


    public StudentDao(StudentDto studentDto){
        this.fName = studentDto.getFirstName();
        this.lName = studentDto.getLastName();
        this.registration = studentDto.getRegistration();
        this.email = studentDto.getEmail();
    }

 }
