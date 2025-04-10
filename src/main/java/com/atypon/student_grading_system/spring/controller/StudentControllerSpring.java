package com.atypon.student_grading_system.spring.controller;

import com.atypon.student_grading_system.models.Student;
import com.atypon.student_grading_system.spring.serucity.JwtService;
import com.atypon.student_grading_system.spring.service.CourseService;
import com.atypon.student_grading_system.spring.service.StudentCourseEnrollmentService;
import com.atypon.student_grading_system.spring.service.StudentService;
import com.atypon.student_grading_system.spring.models.StudentSpring;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.KeyPair;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//
//@Controller
@RestController
@RequestMapping(path = "api/student")
@RequiredArgsConstructor
public class StudentControllerSpring {

    private final StudentService studentService;
    private final JwtService jwtService;
    private final StudentCourseEnrollmentService studentCourseEnrollmentService;


    private Long extractId(String token){
        token = token.replace("Bearer ", "");

        String username = jwtService.extractUsername(token);

        Long userId = studentService.getStudentByUsername(username)
                .map(StudentSpring::getId)
                .orElse(null);

        if (userId == null) {
            throw new RuntimeException("User not found");
        }
        return userId;
    }


    @GetMapping
    public List<Map<String, Object>> getAllStudents(@RequestHeader("Authorization") String token
    , Model model) {

        Long userId = extractId(token);
        List<Map<String, Object>> studentCourses = studentCourseEnrollmentService.getStudentCoursesWithGrades(userId);

        if (!studentCourses.isEmpty()) {
            model.addAttribute("courses", studentCourses);
        }

        for (Map<String ,Object> map : studentCourses)
            map.forEach( (k, v) -> { System.out.println(k + " -> " + v); } );

        return studentCourses;

    }

    @GetMapping("/profile")
    public StudentSpring getProfile(@RequestHeader("Authorization") String token) {
        Long userId = extractId(token);
        Optional<StudentSpring> student = studentService.getStudentById(userId);
        if (student.isEmpty())
            throw new RuntimeException("User not found");

        return student.get();
    }



    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long id,
                              @RequestParam(required = false) String username,
                              @RequestParam(required = false) double gpa
    ) {
        studentService.updateStudent(id , username, gpa);
    }

}

