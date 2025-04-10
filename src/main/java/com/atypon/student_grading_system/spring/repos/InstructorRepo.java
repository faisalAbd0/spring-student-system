package com.atypon.student_grading_system.spring.repos;


import com.atypon.student_grading_system.spring.models.InstructorSpring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructorRepo extends JpaRepository<InstructorSpring, Long> {

    Optional<InstructorSpring> findByUsername(String username);
}
