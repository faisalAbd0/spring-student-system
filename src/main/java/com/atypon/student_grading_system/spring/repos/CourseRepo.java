package com.atypon.student_grading_system.spring.repos;


import com.atypon.student_grading_system.spring.models.CourseSpring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepo extends JpaRepository<CourseSpring, Long> {

    @Query("SELECT course" +
            " FROM CourseSpring course" +
            " WHERE " +
            "course.id = ?1")
    Optional<List<CourseSpring>> findByCoursesId(Long studentId);
}
