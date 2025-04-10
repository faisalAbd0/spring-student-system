package com.atypon.student_grading_system.spring.service;

import com.atypon.student_grading_system.spring.models.CourseSpring;
import com.atypon.student_grading_system.spring.models.StudentCourseEnrollment;
import com.atypon.student_grading_system.spring.models.StudentSpring;
import com.atypon.student_grading_system.spring.models.StudentCourseEnrolmentId;
import com.atypon.student_grading_system.spring.repos.CourseRepo;
import com.atypon.student_grading_system.spring.repos.StudentCourseEnrollmentRepo;
import com.atypon.student_grading_system.spring.repos.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentCourseEnrollmentService {

    private final StudentRepo studentRepo;
    private final CourseRepo courseRepo;
    private final StudentCourseEnrollmentRepo studentCourseEnrollmentRepo;


    public void enrollStudent(Long studentId, Long courseId, double grade) {
        // Fetch Student and Course from the database
        Optional<StudentSpring> studentOpt = studentRepo.findById(studentId);
        Optional<CourseSpring> courseOpt = courseRepo.findById(courseId);

        if (!studentOpt.isPresent() || !courseOpt.isPresent()) {
            throw new RuntimeException("Student or Course not found");
        }

        StudentSpring student = studentOpt.get();
        CourseSpring course = courseOpt.get();

        StudentCourseEnrollment studentCourseEnrollment = new StudentCourseEnrollment(new StudentCourseEnrolmentId(studentId, courseId), student, course, grade);
        studentCourseEnrollmentRepo.save(studentCourseEnrollment);

    }
    public Optional<StudentCourseEnrollment> getStudentEnrollment(Long studentId) {
        return studentCourseEnrollmentRepo.findByStudentId(studentId);
    }
    public List<Map<String, Object>> getStudentCoursesWithGrades(@Param("studentId") Long studentId){
        return studentCourseEnrollmentRepo.getStudentCoursesWithGrades(studentId);
    }

}
