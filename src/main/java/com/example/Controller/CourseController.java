package com.example.Controller;

import com.example.Dto.CourseDto;
import com.example.Dto.CourseResponseDto;
import com.example.Dto.StudentDto;
import com.example.Dto.StudentResponseDto;
import com.example.Service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class CourseController {
    @Autowired
    CourseService courseService;

    @CrossOrigin
    @GetMapping("/getCourses")
    public List<CourseResponseDto> getCourses(){
        return courseService.getCourses();
    }

    @GetMapping("/getCourse/{id}")
    public CourseResponseDto getCourseById(@PathVariable("id") int id){
        return courseService.getCourseById(id);
    }

    @GetMapping("/getCourse")
    public CourseResponseDto getCourseByName(@RequestParam("name") String name){
        return courseService.getCourseByName(name);
    }

    @CrossOrigin
    @PostMapping(value = "/addCourse")

    public CourseResponseDto saveCourse(@Valid @RequestBody CourseDto courseDto){
        return courseService.saveCourse(courseDto);
    }

    @CrossOrigin
    @PutMapping("/updateCourse/{id}")
    public CourseResponseDto updateCourse(@Valid @PathVariable("id") int id, @RequestBody CourseDto courseDto) {
        return courseService.updateCourse(id,courseDto);
    }

    @CrossOrigin
    @DeleteMapping("/deleteCourse/{id}")
    public HashMap<String,String> deleteCourseById(@PathVariable("id") int id){
        return courseService.deleteCourseById(id);
    }
}
