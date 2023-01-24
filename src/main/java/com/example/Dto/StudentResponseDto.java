package com.example.Dto;

import com.example.Model.StudentDao;

public class StudentResponseDto {
    long id;
    String registration;
    String firstName;
    String lastName;
    String email;

    public StudentResponseDto() {

    }
    public StudentResponseDto(StudentDao studentDao){
        this.id = studentDao.getId();
        this.firstName = studentDao.getfName();
        this.lastName = studentDao.getlName();
        this.registration = studentDao.getRegistration();
        this.email = studentDao.getEmail();
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
