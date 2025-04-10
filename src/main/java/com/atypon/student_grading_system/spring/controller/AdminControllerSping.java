package com.atypon.student_grading_system.spring.controller;


import com.atypon.student_grading_system.models.Admin;
import com.atypon.student_grading_system.models.Student;
import com.atypon.student_grading_system.spring.models.AdminSpring;
import com.atypon.student_grading_system.spring.models.CourseSpring;
import com.atypon.student_grading_system.spring.models.InstructorSpring;
import com.atypon.student_grading_system.spring.models.StudentSpring;
import com.atypon.student_grading_system.spring.service.AdminService;
import com.atypon.student_grading_system.spring.service.CourseService;
import com.atypon.student_grading_system.spring.service.InstructorService;
import com.atypon.student_grading_system.spring.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin")

@RequiredArgsConstructor
public class AdminControllerSping {

    private final AdminService adminService;
    private final StudentService studentService;
    private final CourseService courseService;
    private final InstructorService instructorService;



    @GetMapping
    public List<AdminSpring> getAdmin() {
        return adminService.getAdmins();
    }
    @PostMapping
    public void add(AdminSpring admin) {
        adminService.addAdmin(admin);
    }

    @PostMapping("add/student")
    public void add(@RequestBody StudentSpring student) {
        studentService.addStudent(student);
    }
    @PostMapping("add/course")
    public void add(@RequestBody CourseSpring course) {
        courseService.saveCourse(course);
    }
    @PostMapping("add/instructor")
    public void add(@RequestBody InstructorSpring instructor) {
        instructorService.addInstructor(instructor);
    }

    @DeleteMapping("course/delete/{courseId}")
    public void delete(@PathVariable("courseId") Long id) {
        courseService.deleteCourse(id);
    }

    @DeleteMapping("instructor/delete/{instructorId}")
    public void deleteInstructor(@PathVariable("instructorId") Long id) {
        instructorService.deleteInstructor(id);
    }

    @DeleteMapping(path = "student/delete/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id) {
        studentService.deleteStudent(id);
    }




}
