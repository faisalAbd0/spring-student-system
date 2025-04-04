package com.atypon.student_grading_system.spring.repos;

import com.atypon.student_grading_system.spring.models.StudentSpring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<StudentSpring,Long> {
    Optional<StudentSpring> findStudentSpringByUsername(String username);
    Optional<StudentSpring> findByUsername(String username);
}
