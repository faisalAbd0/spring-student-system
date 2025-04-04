package com.atypon.student_grading_system.spring.auth;


import com.atypon.student_grading_system.spring.models.AdminSpring;
import com.atypon.student_grading_system.spring.models.InstructorSpring;

import com.atypon.student_grading_system.spring.models.StudentSpring;
import com.atypon.student_grading_system.spring.repos.AdminRepo;
import com.atypon.student_grading_system.spring.repos.InstructorRepo;
import com.atypon.student_grading_system.spring.repos.StudentRepo;

import com.atypon.student_grading_system.spring.serucity.JwtService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {


    private final StudentRepo studentRepo;
    private final InstructorRepo instructorRepo;
    private final AdminRepo adminRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        UserDetails user = findUserByUsername(request.getUsername());

        String jwt = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwt).build();
    }

    public AuthenticationResponse register(RegisterRequest request) {
        if (request.getUsername() == null || request.getPassword() == null || request.getRole() == null) {
            throw new IllegalArgumentException("Invalid request");
        }
        if (checkUsernameExists(request.getUsername())) {
            throw new IllegalStateException("Username already exists");
        }

        UserDetails user;
        switch (request.getRole()) {
            case Student:
                StudentSpring student = new StudentSpring(
                        request.getUsername(),
                        passwordEncoder.encode(request.getPassword()),
                        0.0,
                        request.getDateOfBirth()
                );

                studentRepo.save(student);
                user = student;
                break;

            case Instructor:
                InstructorSpring instructor = new InstructorSpring(
                        request.getUsername(),
                        passwordEncoder.encode(request.getPassword())
                );

                instructorRepo.save(instructor);
                user = instructor;
                break;

            case Admin:
                AdminSpring admin = new AdminSpring(
                        request.getUsername(),
                        passwordEncoder.encode(request.getPassword())
                );


                user = admin;
                adminRepo.save(admin);
                break;

            default:
                throw new IllegalArgumentException("Invalid role");
        }

        var jwt = jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(jwt).build();

    }
    private UserDetails findUserByUsername(String username) {
        return studentRepo.findStudentSpringByUsername(username)
                .map(UserDetails.class::cast)
                .orElseGet(() -> instructorRepo.findByUsername(username)
                        .map(UserDetails.class::cast)
                        .orElseGet(() -> adminRepo.findByUsername(username)
                                .map(UserDetails.class::cast)
                                .orElseThrow(() -> new UsernameNotFoundException("User not found"))));
    }

    private boolean checkUsernameExists(String username) {
        return studentRepo.findStudentSpringByUsername(username).isPresent() ||
                instructorRepo.findByUsername(username).isPresent() ||
                adminRepo.findByUsername(username).isPresent();
    }

}
