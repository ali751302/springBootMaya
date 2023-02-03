package com.example.Controller;

import com.example.Dto.StudentDto;
import com.example.Dto.StudentResponseDto;
import com.example.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<StudentResponseDto>> getStudents(){
        return ResponseEntity.ok(studentService.getStudents());
    }

    @GetMapping("/getStudent/{id}")
    public ResponseEntity<StudentResponseDto> getStudentById(@PathVariable("id") int id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @GetMapping("/getStudent")
    public ResponseEntity<StudentResponseDto> getStudentByRegistration(@RequestParam("reg") String registration){
        return ResponseEntity.ok(studentService.getStudentByRegistration(registration));
    }

    @CrossOrigin
    @PostMapping(value = "/addStudent")

    public ResponseEntity<StudentResponseDto> saveStudent(@Valid @RequestBody StudentDto studentDto){
        return ResponseEntity.ok(studentService.saveStudent(studentDto));
    }

    @CrossOrigin
    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<StudentResponseDto> updateStudent(@Valid @PathVariable("id") int id, @RequestBody StudentDto studentDto) {
        return ResponseEntity.ok(studentService.updateStudent(id,studentDto));
    }

    @CrossOrigin
    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<HashMap<String,String>> deleteStudentById(@PathVariable("id") int id){
        return ResponseEntity.ok(studentService.deleteStudentById(id));
    }

//    @PatchMapping("/updateStudentData/{id}")
//    public StudentResponseDto updateStudentData(@Valid @PathVariable("id") int id,@Valid @RequestBody StudentDto studentDto) {
//        return studentService.updateStudentData(id,studentDto);
//    }
}
