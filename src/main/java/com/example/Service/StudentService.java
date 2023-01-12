package com.example.Service;

import com.example.Dto.StudentDto;
import com.example.Model.StudentDao;
import com.example.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public List<StudentDto> getStudents(){
        List<StudentDao> studentDaoList = studentRepository.findAll();
        List<StudentDto> studentDtoList = studentDaoList.stream().filter(std -> !std.getRegistration().equals("undefined"))
                .map(std -> new StudentDto(std)).collect(Collectors.toList());
        return studentDtoList;
    }
    public StudentDto getStudentById(int id) {
        Optional<StudentDao> studentDao = studentRepository.findById(id);
        if(studentDao.isPresent()) {
            return new StudentDto(studentDao.get());
        }
        else{
            return new StudentDto();
        }
    }
    public StudentDto getStudentByRegistration(String registration){
        Optional<StudentDao> studentDao = studentRepository.findByRegistration(registration);
        if(studentDao.isPresent()){
            return new StudentDto(studentDao.get());
        }
        else {
            return new StudentDto();
        }
    }
    public StudentDto saveStudent(StudentDto studentDto){
        StudentDao studentDao = new StudentDao(studentDto);
        return new StudentDto(studentRepository.save(studentDao));
    }

    public StudentDto updateStudent(int id, StudentDto studentDto) {
        StudentDao studentDao = new StudentDao(studentDto);
        studentDao.setId(id);
        return new StudentDto(studentRepository.save(studentDao));
    }

    public HashMap<String, String> deleteStudentById(int id){
        Optional<StudentDao> studentDao = studentRepository.findById(id);
        HashMap<String,String> response = new HashMap<>();
        if(studentDao.isPresent()){
            studentRepository.deleteAllById(Collections.singleton(id));
            response.put( "Message", "Record Deleted of id = "+id);
        }
        else {
            response.put( "Message", "Record Not Found of id = "+id);
        }
        return response;
    }
}
