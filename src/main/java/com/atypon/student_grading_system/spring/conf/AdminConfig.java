package com.atypon.student_grading_system.spring.conf;


import com.atypon.student_grading_system.models.Admin;
import com.atypon.student_grading_system.spring.models.AdminSpring;
import com.atypon.student_grading_system.spring.models.CourseSpring;
import com.atypon.student_grading_system.spring.repos.AdminRepo;
import com.atypon.student_grading_system.spring.repos.CourseRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminConfig {
    @Bean
    CommandLineRunner commandLineRunner3(AdminRepo adminRepo) {
        return args -> {
            AdminSpring admin = new AdminSpring("admin" , "$2a$12$pAq4PnXQDv75vcDrlUxafeVVbXRcnC9y3wK3xGYbCjl9eG/NKNiB2");
            adminRepo.save(admin);
        };
    }
}
