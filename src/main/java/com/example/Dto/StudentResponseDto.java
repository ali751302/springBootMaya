package com.example.Dto;

import com.example.Model.StudentDao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentResponseDto {
    long id;
    String registration;
    String firstName;
    String lastName;
    String email;

    public StudentResponseDto(StudentDao studentDao){
        this.id = studentDao.getId();
        this.firstName = studentDao.getFName();
        this.lastName = studentDao.getLName();
        this.registration = studentDao.getRegistration();
        this.email = studentDao.getEmail();
    }
}
