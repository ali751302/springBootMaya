package com.example.Dto;

import com.example.Model.StudentDao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class StudentDto {
    @Pattern(regexp = "^(L1|l1)([s|f]|[S|F])[0-9]{2}([a-z]|[A-Z]){4}[0-9]{4}$",
            message = "Invalid Registration Number Sequence")
    @NotNull
    @NotBlank
    String registration;
    @Size(min = 5, max = 25, message = "First name should be of 5 - 25 characters")
    @NotNull(message = "You must have to include first name in request body")
    @NotBlank(message = "First Name should not be blank")
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
