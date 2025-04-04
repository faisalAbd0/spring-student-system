package com.atypon.student_grading_system.spring.repos;


import com.atypon.student_grading_system.spring.models.AdminSpring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepo extends JpaRepository<AdminSpring, Long> {

    Optional<Object> findByUsername(String username);


}
