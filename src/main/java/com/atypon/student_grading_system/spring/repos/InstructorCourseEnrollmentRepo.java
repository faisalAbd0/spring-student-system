package com.atypon.student_grading_system.spring.repos;

import com.atypon.student_grading_system.spring.models.InstructorCourseEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface InstructorCourseEnrollmentRepo extends JpaRepository<InstructorCourseEnrollment, Long> {
    @Query("SELECT new map(" +
            "i.id AS instructorId," +
            " i.username AS instructorName, " +
            "c.id AS courseId, c.courseName AS courseName," +
            " c.courseLimit AS courseLimit " +
            ") " +
            "FROM InstructorSpring i " +
            "JOIN i.instructorCourseEnrollments ice " +
            "JOIN CourseSpring c ON ice.course.id = c.id " +
            "WHERE i.id = :instructorId")
    List<Map<String, Object>> getInstructorCoursesWithStudents(Long instructorId);

    @Modifying
    @Query("UPDATE StudentCourseEnrollment e " +
            "SET e.grade = :newGrade " +
            "WHERE e.student.id = :studentId AND e.course.id = :courseId")
    void updateStudentGrade(@Param("studentId") Long studentId,
                            @Param("courseId") Long courseId,
                            @Param("newGrade") double newGrade);

}
