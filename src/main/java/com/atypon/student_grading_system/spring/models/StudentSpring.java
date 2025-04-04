package com.atypon.student_grading_system.spring.models;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class StudentSpring implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String username;
    private String password;
    private LocalDate dateOfBirth;
    @Transient
    private int age;
    private double gpa;


    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentCourseEnrollment> studentCourseEnrollments = new ArrayList<>();


    public int getAge() {
        return LocalDate.now().getYear() - dateOfBirth.getYear();
    }

    public StudentSpring(String username, String password, double gpa , LocalDate dateOfBirth) {
        this.username = username;
        this.password = password;
        this.gpa = gpa;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(Role.Student.name()));
    }
}
