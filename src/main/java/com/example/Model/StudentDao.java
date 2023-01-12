package com.example.Model;

import com.example.Dto.StudentDto;
import jakarta.persistence.*;

@Entity
@Table(name = "Student")
public class StudentDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String registration;
    String fName;
    String lName;

    public StudentDao(){

    }

    public StudentDao(StudentDto studentDto){
        this.fName = studentDto.getFirstName();
        this.lName = studentDto.getLastName();
        this.registration = studentDto.getRegistration();
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

    public void setlName(String lName) {
        this.lName = lName;
    }
}
