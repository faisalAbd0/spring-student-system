package com.atypon.student_grading_system.spring.service;



import com.atypon.student_grading_system.spring.models.AdminSpring;
import com.atypon.student_grading_system.spring.repos.AdminRepo;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final AdminRepo adminRepo;

    @Autowired
    public AdminService(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    public void addAdmin(AdminSpring admin) {
        adminRepo.save(admin);
    }

    public List<AdminSpring> getAdmins() {
        return adminRepo.findAll();
    }
}
