package com.example.Dto;

import com.example.Model.StudentDao;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;


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
//    @Pattern(regexp = "@+([a-z]|[A-z]){2,}(\\.+([a-z]|[A-z]){2,}){1,2}$",
//            message = "Invalid Email Sequence")
    @Email(message = "Invalid Email Sequence")
    String email;

    public StudentDto() {
    }

    public StudentDto(StudentDao studentDao){
        this.firstName = studentDao.getfName();
        this.lastName = studentDao.getlName();
        this.registration = studentDao.getRegistration();
        this.email = studentDao.getEmail();
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

    public StudentDto assignValue(StudentDto request)
    {
        if(request.getFirstName() != null){
            this.setFirstName(request.getFirstName());
        }
        if(request.getLastName() != null){
            this.setLastName(request.getLastName());
        }
        if(request.getRegistration() != null){
            this.setRegistration(request.getRegistration());
        }
        if(request.getEmail() != null){
            this.setEmail(request.getEmail());
        }
        return request;
    }
    @Override
    public String toString() {
        return "StudentDto{" +
                "registration='" + registration + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
