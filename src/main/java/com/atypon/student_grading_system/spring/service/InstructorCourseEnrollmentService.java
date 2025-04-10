package com.atypon.student_grading_system.spring.service;


import com.atypon.student_grading_system.spring.models.*;
import com.atypon.student_grading_system.spring.repos.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InstructorCourseEnrollmentService  {
    private final InstructorRepo instructorRepo;
    private final CourseRepo courseRepo;
    private final InstructorCourseEnrollmentRepo instructorCourseEnrollmentRepo;


    public List<Map<String, Object>> getInstructorCoursesWithStudents(Long instructorId){
        return instructorCourseEnrollmentRepo.getInstructorCoursesWithStudents(instructorId);
    }

    @Transactional
    public void setStudentGrade(Long studentId, Long courseId, double newGrade) {
        instructorCourseEnrollmentRepo.updateStudentGrade(studentId, courseId ,newGrade);
    }

    public void enrollInstructor(Long instructorId, Long courseId) {

        Optional<InstructorSpring> instructorOpt = instructorRepo.findById(instructorId);
        Optional<CourseSpring> courseOpt = courseRepo.findById(courseId);

        if (instructorOpt.isEmpty() || courseOpt.isEmpty()) {
            throw new RuntimeException("Student or Course not found");
        }

        InstructorSpring instructor = instructorOpt.get();
        CourseSpring course = courseOpt.get();

        InstructorCourseEnrollment instructorCourseEnrollment = new InstructorCourseEnrollment(new InstructorCourseEnrollmentId(instructorId,courseId),instructor,course);
        instructorCourseEnrollmentRepo.save(instructorCourseEnrollment);

    }

}
