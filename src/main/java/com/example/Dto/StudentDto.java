package com.example.Dto;

import com.example.Model.StudentDao;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
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


//    public StudentDto assignValue(StudentDto request)
//    {
//        if(request.getFirstName() != null){
//            this.setFirstName(request.getFirstName());
//        }
//        if(request.getLastName() != null){
//            this.setLastName(request.getLastName());
//        }
//        if(request.getRegistration() != null){
//            this.setRegistration(request.getRegistration());
//        }
//        if(request.getEmail() != null){
//            this.setEmail(request.getEmail());
//        }
//        return request;
//    }

}
