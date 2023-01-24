package com.example.Repository;


import com.example.Model.CourseDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<CourseDao, Integer> {
    Optional<CourseDao> findByCourseNameContainsIgnoreCase(String courseName);
}
