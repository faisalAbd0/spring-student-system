package com.atypon.student_grading_system.spring.controller;


import com.atypon.student_grading_system.models.Course;
import com.atypon.student_grading_system.spring.models.CourseSpring;
import com.atypon.student_grading_system.spring.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/course")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @GetMapping
    public List<CourseSpring> getAllCourses() {
        return courseService.getAllCourses();

    }

}
