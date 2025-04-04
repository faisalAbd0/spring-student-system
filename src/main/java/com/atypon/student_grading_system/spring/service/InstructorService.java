package com.atypon.student_grading_system.spring.service;

import com.atypon.student_grading_system.spring.models.InstructorSpring;
import com.atypon.student_grading_system.spring.repos.InstructorRepo;
import io.micrometer.observation.ObservationFilter;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    private final InstructorRepo instructorRepo;
    @Autowired
    public InstructorService(InstructorRepo instructorRepo) {
        this.instructorRepo = instructorRepo;
    }
    public List<InstructorSpring> getAllInstructors() {
        return instructorRepo.findAll();
    }

    public void addInstructor(InstructorSpring instructorSpring) {
        instructorRepo.save(instructorSpring);
    }

    public void deleteInstructor(Long id) {
        boolean isExist = instructorRepo.existsById(id);
        if (isExist) {
            throw new IllegalStateException("No Such Instructor");
        }
        instructorRepo.deleteById(id);
    }

    public Optional<InstructorSpring> getInstructorByUsername(String username) {
        return instructorRepo.findByUsername(username);
    }

    public Optional<InstructorSpring> getInstructorId(Long userId) {
        return instructorRepo.findById(userId);
    }
}
