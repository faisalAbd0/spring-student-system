package com.atypon.student_grading_system.spring.service;

import com.atypon.student_grading_system.models.Course;
import com.atypon.student_grading_system.spring.models.CourseSpring;
import com.atypon.student_grading_system.spring.repos.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepo courseRepo;
    @Autowired
    public CourseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public List<CourseSpring> getAllCourses() {
        return courseRepo.findAll();
    }


    public void saveCourse(CourseSpring courseSpring) {
        courseRepo.save(courseSpring);
    }
    public void deleteCourse(Long courseId) {
        courseRepo.deleteById(courseId);
    }
    public Optional<List<CourseSpring>> getCoursesByCourseId(Long studentId) {
        return courseRepo.findByCoursesId(studentId);
    }
}
