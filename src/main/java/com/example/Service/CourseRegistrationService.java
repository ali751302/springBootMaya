package com.example.Service;

import com.example.Dto.*;
import com.example.Model.CourseDao;
import com.example.Model.CourseRegistrationDao;
import com.example.Model.StudentDao;
import com.example.Repository.CourseRegistrationRepository;
import com.example.Repository.CourseRepository;
import com.example.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseRegistrationService {
    @Autowired
    CourseRegistrationRepository courseRegistrationRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;


    public CourseRegistrationResponseDto CourseRegistrationResponseDto(CourseRegistrationDto courseRegistrationDto) {
        Optional<StudentDao> studentDao = studentRepository.findById(courseRegistrationDto.getStudent());
        Optional<CourseDao> courseDao = courseRepository.findById(courseRegistrationDto.getCourse());
        courseRegistrationDto.setRegisteredAt(LocalDateTime.now());

        if ((studentDao.isPresent()) && courseDao.isPresent())
        {
            CourseRegistrationDao courseRegistrationDao=
                    new CourseRegistrationDao(studentDao.get(), courseDao.get(),
                            LocalDateTime.now());

            return new CourseRegistrationResponseDto(courseRegistrationRepository.save(courseRegistrationDao));
        }
        return new CourseRegistrationResponseDto();
    }

    public RegisterCoursesResponse getStudentCoursesById(Integer id) {
        Optional<List<CourseRegistrationDao>> courseRegistrationDaoList =
                courseRegistrationRepository.findByStudentId(id);
        RegisterCoursesResponse registerCoursesResponse = null;
        if(courseRegistrationDaoList.isPresent()){
            List<CourseRegistrationResponseDto> courseRegistrationResponseDtoList = courseRegistrationDaoList.get().stream().
                    map(crr -> new CourseRegistrationResponseDto(crr)).collect(Collectors.toList());
            registerCoursesResponse = createResponse(courseRegistrationResponseDtoList);
        }
        return Objects.nonNull(registerCoursesResponse)? registerCoursesResponse : null;

    }

    public RegisterCoursesResponse createResponse(List<CourseRegistrationResponseDto> courseRegistrationResponseDtoList){
        RegisterCoursesResponse registerCoursesResponse = new RegisterCoursesResponse();
        registerCoursesResponse.setCourses(new ArrayList<>());
        RegisterCourse registerCourse = new RegisterCourse();
        registerCoursesResponse.setStudentName(courseRegistrationResponseDtoList.get(0).getStudent().getFirstName());
        registerCoursesResponse.setRegistrationNo(courseRegistrationResponseDtoList.get(0).getStudent().getRegistration());
        courseRegistrationResponseDtoList.forEach(course -> {
            registerCourse.setCourse(course.getCourse());
            registerCourse.setRegisteredAt(course.getRegisteredAt());
            registerCoursesResponse.addCourse(registerCourse);
        });
        return registerCoursesResponse;
    }
}
