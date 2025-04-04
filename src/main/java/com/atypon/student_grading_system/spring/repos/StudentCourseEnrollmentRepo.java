package com.atypon.student_grading_system.spring.repos;

import com.atypon.student_grading_system.models.Student;
import com.atypon.student_grading_system.spring.models.StudentCourseEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface StudentCourseEnrollmentRepo extends JpaRepository<StudentCourseEnrollment, Long> {


    @Query("SELECT new map(" +
            "s.id AS student_id," +
            " s.username AS student_name," +
            " c.id AS course_id," +
            " c.courseName AS course_name," +
            " e.grade AS grade) "
            +
            "FROM StudentSpring s " +
            "JOIN StudentCourseEnrollment e ON s.id = e.student.id " +
            "JOIN CourseSpring c ON e.course.id = c.id " +
            "WHERE s.id = :studentId")
    List<Map<String, Object>> getStudentCoursesWithGrades(Long studentId);

    Optional<StudentCourseEnrollment> findByStudentId(Long studentId);

}

