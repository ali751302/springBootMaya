package com.example.Service;

import com.example.Dto.CourseDto;
import com.example.Dto.CourseResponseDto;
import com.example.Dto.StudentResponseDto;
import com.example.Model.CourseDao;
import com.example.Model.StudentDao;
import com.example.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public List<CourseResponseDto> getCourses() {
        List<CourseDao> courseDaoList = courseRepository.findAll();
        List<CourseResponseDto> courseDtoList = courseDaoList.stream()
                .map(crs -> new CourseResponseDto(crs)).collect(Collectors.toList());
        return courseDtoList;
    }

    public CourseResponseDto getCourseById(int id) {
        Optional<CourseDao> courseDao = courseRepository.findById(id);
        if(courseDao.isPresent()) {
            return new CourseResponseDto(courseDao.get());
        }
        else{
            return new CourseResponseDto();
        }
    }

    public CourseResponseDto getCourseByName(String name) {
        Optional<CourseDao> courseDao = courseRepository.findByCourseNameContainsIgnoreCase(name);
        if(courseDao.isPresent()){
            return new CourseResponseDto(courseDao.get());
        }
        else {
            return new CourseResponseDto();
        }
    }

    public CourseResponseDto saveCourse(CourseDto courseDto) {
        CourseDao courseDao = new CourseDao(courseDto);
        return new CourseResponseDto(courseRepository.save(courseDao));
    }

    public CourseResponseDto updateCourse(int id, CourseDto courseDto) {
        CourseDao courseDao = new CourseDao(courseDto);
        courseDao.setId(id);
        return new CourseResponseDto(courseRepository.save(courseDao));
    }

    public HashMap<String, String> deleteCourseById(int id) {
        Optional<CourseDao> courseDao = courseRepository.findById(id);
        HashMap<String,String> response = new HashMap<>();
        if(courseDao.isPresent()){
            courseRepository.deleteAllById(Collections.singleton(id));
            response.put( "Message", "Record Deleted of id = "+id);
        }
        else {
            response.put( "Message", "Record Not Found of id = "+id);
        }
        return response;
    }
}
