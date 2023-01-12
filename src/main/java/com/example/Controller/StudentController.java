package com.example.Controller;

import com.example.Dto.StudentDto;
import com.example.Model.StudentDao;
import com.example.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/getStudents")
    public List<StudentDto> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/getStudent/{id}")
    public StudentDto getStudentById(@PathVariable("id") int id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/getStudent")
    public StudentDto getStudentByRegistration(@RequestParam("reg") String registration){
        return studentService.getStudentByRegistration(registration);
    }

    @PostMapping("/addStudent")
    public StudentDto saveStudent(@Valid @RequestBody StudentDto studentDto){
        return studentService.saveStudent(studentDto);
    }

    @PutMapping("/updateStudent/{id}")
    public StudentDto updateStudent(@Valid @PathVariable("id") int id, @RequestBody StudentDto studentDto) {
        return studentService.updateStudent(id,studentDto);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public HashMap<String,String> deleteStudentById(@PathVariable("id") int id){
        return studentService.deleteStudentById(id);
    }
}
