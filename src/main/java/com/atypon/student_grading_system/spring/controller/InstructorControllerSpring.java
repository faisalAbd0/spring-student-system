package com.atypon.student_grading_system.spring.controller;


import com.atypon.student_grading_system.models.Instructor;
import com.atypon.student_grading_system.spring.models.*;
import com.atypon.student_grading_system.spring.serucity.JwtService;
import com.atypon.student_grading_system.spring.service.InstructorCourseEnrollmentService;
import com.atypon.student_grading_system.spring.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/instructor")
@RequiredArgsConstructor
public class InstructorControllerSpring {


    private final InstructorService instructorService;
    private final JwtService jwtService;
    private final InstructorCourseEnrollmentService instructorCourseEnrollmentService;

    private Long extractId(String token){
        token = token.replace("Bearer ", "");

        String username = jwtService.extractUsername(token);

        Long userId = instructorService.getInstructorByUsername(username)
                .map(InstructorSpring::getId)
                .orElse(null);

        if (userId == null) {
            throw new RuntimeException("User not found");
        }
        return userId;
    }

    @GetMapping("profile")
    public InstructorSpring displayInstructorById(@RequestHeader("Authorization") String token){
        Long userId = extractId(token);
        Optional<InstructorSpring> instructorSpring = instructorService.getInstructorId(userId);
        if (instructorSpring.isEmpty())
            throw new IllegalStateException("User not found");
        return instructorSpring.get();
    }

    @GetMapping
    public List<Map<String, Object>> displayInstructorCoursesWithStudents(@RequestHeader("Authorization") String token) {
        Long userId = extractId(token);
        return instructorCourseEnrollmentService.getInstructorCoursesWithStudents(userId);
    }


    @PatchMapping("/grade")
    public void updateInstructor(@RequestHeader("Authorization") String token,
                                 @RequestBody GradeUpdateRequest gradeUpdateRequest
    ) {
        if (token == null || token.isEmpty()) {
            throw new IllegalArgumentException("Invalid token");
        }
        if (gradeUpdateRequest.getStudentId() < 0 || gradeUpdateRequest.getCourseId() < 0) {
            throw new IllegalArgumentException("Invalid courseId or studentId");
        }
        instructorCourseEnrollmentService.setStudentGrade(gradeUpdateRequest.getStudentId() , gradeUpdateRequest.getStudentId(), gradeUpdateRequest.getNewGrade());
    }


}
