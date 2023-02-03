package com.example.Controller;


import com.example.Dto.CourseRegistrationDto;
import com.example.Dto.CourseRegistrationResponseDto;
import com.example.Dto.RegisterCoursesResponse;
import com.example.Service.CourseRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class CourseRegistrationController {
    @Autowired
    CourseRegistrationService courseRegistrationService;

    @CrossOrigin
    @PostMapping("/registerCourse")
    public CourseRegistrationResponseDto registerCourse(@RequestBody CourseRegistrationDto courseRegistrationDto) {
        return courseRegistrationService.CourseRegistrationResponseDto(courseRegistrationDto);
    }

    @CrossOrigin
    @GetMapping("/getStudentCoursesById/{id}")
    public RegisterCoursesResponse getStudentCoursesById(@PathVariable("id") Integer id){
        return courseRegistrationService.getStudentCoursesById(id);
    }
}
