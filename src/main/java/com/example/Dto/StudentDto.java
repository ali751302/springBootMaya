package com.example.Dto;

import com.example.Model.StudentDao;

public class StudentDto {
    String registration;
    String firstName;
    String lastName;

    public StudentDto() {
    }

    public StudentDto(StudentDao studentDao){
        this.firstName = studentDao.getfName();
        this.lastName = studentDao.getlName();
        this.registration = studentDao.getRegistration();
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
