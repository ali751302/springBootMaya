package com.example.Controller;

import com.example.Dto.StudentDto;
import com.example.Dto.StudentResponseDto;
import com.example.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class StudentController {
    @Autowired
    StudentService studentService;

    @CrossOrigin
    @GetMapping("/getStudents")
    public List<StudentResponseDto> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/getStudent/{id}")
    public StudentResponseDto getStudentById(@PathVariable("id") int id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/getStudent")
    public StudentResponseDto getStudentByRegistration(@RequestParam("reg") String registration){
        return studentService.getStudentByRegistration(registration);
    }

    @CrossOrigin
    @PostMapping(value = "/addStudent")

    public StudentResponseDto saveStudent(@Valid @RequestBody StudentDto studentDto){
        return studentService.saveStudent(studentDto);
    }

    @CrossOrigin
    @PutMapping("/updateStudent/{id}")
    public StudentResponseDto updateStudent(@Valid @PathVariable("id") int id, @RequestBody StudentDto studentDto) {
        return studentService.updateStudent(id,studentDto);
    }

    @CrossOrigin
    @DeleteMapping("/deleteStudent/{id}")
    public HashMap<String,String> deleteStudentById(@PathVariable("id") int id){
        return studentService.deleteStudentById(id);
    }

//    @PatchMapping("/updateStudentData/{id}")
//    public StudentResponseDto updateStudentData(@Valid @PathVariable("id") int id,@Valid @RequestBody StudentDto studentDto) {
//        return studentService.updateStudentData(id,studentDto);
//    }
}
