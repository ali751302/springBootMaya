package com.example.Repository;

import com.example.Model.CourseDao;
import com.example.Model.CourseRegistrationDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRegistrationRepository extends JpaRepository<CourseRegistrationDao, Integer> {
    Optional<List<CourseRegistrationDao>> findByStudentId (Integer studentId);
}
