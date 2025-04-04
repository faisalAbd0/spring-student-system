package com.atypon.student_grading_system.spring.serucity;


import com.atypon.student_grading_system.models.Student;
import com.atypon.student_grading_system.spring.repos.AdminRepo;
import com.atypon.student_grading_system.spring.repos.InstructorRepo;
import com.atypon.student_grading_system.spring.repos.StudentRepo;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class AppConfig {
    private final StudentRepo studentRepo;
    private final InstructorRepo instructorRepo;
    private final AdminRepo adminRepo;


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> studentRepo.findStudentSpringByUsername(username)
                .map(UserDetails.class::cast)
                .orElseGet(() -> instructorRepo.findByUsername(username)
                        .map(UserDetails.class::cast)
                        .orElseGet(() -> adminRepo.findByUsername(username)
                                .map(UserDetails.class::cast)
                                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"))));
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
