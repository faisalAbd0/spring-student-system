package com.atypon.student_grading_system.spring.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table
@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class CourseSpring {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String courseName;
    private int courseLimit;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentCourseEnrollment> studentCourseEnrollments = new ArrayList<>();

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InstructorCourseEnrollment> instructorCourseEnrollments = new ArrayList<>();

    public CourseSpring(String courseName, int courseLimit) {
        this.courseName = courseName;
        this.courseLimit = courseLimit;
    }

}
