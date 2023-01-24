package com.example.Model;

import com.example.Dto.StudentDto;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Student")
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
    Set<CourseRegistration> registrations;

    public StudentDao(){

    }

    public StudentDao(StudentDto studentDto){
        this.fName = studentDto.getFirstName();
        this.lName = studentDto.getLastName();
        this.registration = studentDto.getRegistration();
        this.email = studentDto.getEmail();
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

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
}
