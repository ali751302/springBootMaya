package com.example.Repository;

import com.example.Model.StudentDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentDao, Integer> {
    Optional<StudentDao> findByRegistrationContainingIgnoreCase(String registration);

}
