package com.example.Service;

import com.example.Dto.StudentDto;
import com.example.Dto.StudentResponseDto;
import com.example.Model.StudentDao;
import com.example.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public List<StudentResponseDto> getStudents(){
        List<StudentDao> studentDaoList = studentRepository.findAll();
        List<StudentResponseDto> studentDtoList = studentDaoList.stream().filter(std -> !std.getRegistration().equals("undefined"))
                .map(std -> new StudentResponseDto(std)).collect(Collectors.toList());
        return studentDtoList;
    }
    public StudentResponseDto getStudentById(int id) {
        Optional<StudentDao> studentDao = studentRepository.findById(id);
        if(studentDao.isPresent()) {
            return new StudentResponseDto(studentDao.get());
        }
        else{
            return new StudentResponseDto();
        }
    }
    public StudentResponseDto getStudentByRegistration(String registration){
        Optional<StudentDao> studentDao = studentRepository.findByRegistrationContainingIgnoreCase(registration);
        if(studentDao.isPresent()){
            return new StudentResponseDto(studentDao.get());
        }
        else {
            return new StudentResponseDto();
        }
    }
    public StudentResponseDto saveStudent(StudentDto studentDto){
        StudentDao studentDao = new StudentDao(studentDto);
        return new StudentResponseDto(studentRepository.save(studentDao));
    }

    public StudentResponseDto updateStudent(int id, StudentDto studentDto) {
        StudentDao studentDao = new StudentDao(studentDto);
        studentDao.setId(id);
        return new StudentResponseDto(studentRepository.save(studentDao));
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

//    public StudentResponseDto updateStudentData(int id, StudentDto request)
//    {
//        Optional<StudentDao> studentDao = studentRepository.findById(id);
//        StudentDto studentDto = null;
//        if(studentDao.isPresent())
//        {
//            studentDto = new StudentDto(studentDao.get());
//            studentDto.assignValue(request);
//            StudentDao studentDao1 = new StudentDao(studentDto);
//            studentDao1.setId(id);
//            studentRepository.save(studentDao1);
//            return studentDto;
//        }
//        else{
//
//        }
//
//        return studentDto;
//    }
}
