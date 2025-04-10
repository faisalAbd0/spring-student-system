package com.atypon.student_grading_system.spring.service;

import com.atypon.student_grading_system.models.Student;
import com.atypon.student_grading_system.spring.models.StudentSpring;
import com.atypon.student_grading_system.spring.repos.StudentRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepo studentRepo;

    public List<StudentSpring> getStudent() {
        return studentRepo.findAll();
    }

    public Optional<StudentSpring> getStudentByUsername(String username) {
        return studentRepo.findByUsername(username);
    }
    public void addStudent(StudentSpring student) {
        System.out.println(student);
        Optional<StudentSpring> studentByUsername = studentRepo.findStudentSpringByUsername(student.getUsername()); ;
        if (studentByUsername.isPresent())
            throw new IllegalStateException("username exsited");

        studentRepo.save(student);
    }

    public void deleteStudent(Long id) {
        boolean isExist =studentRepo.existsById(id);
        if (!isExist)
            throw new IllegalStateException("student not found");

        studentRepo.deleteById(id);
    }


    public Optional<StudentSpring> getStudentById(Long userId) {
        return studentRepo.findById(userId) ;
    }


    @Transactional
    public void updateStudent(Long id, String username, double gpa) {

        StudentSpring student = studentRepo.findById(id).orElseThrow(
                () -> new IllegalStateException("student not found")
        );
        if (username != null && !username.isEmpty() && !username.equals(student.getUsername())
        ) {
            Optional<StudentSpring> studentByUsername = studentRepo.findStudentSpringByUsername(username);
            if (studentByUsername.isPresent())
                throw new IllegalStateException("username exsited");
           student.setUsername(username);
        }
    }

}
