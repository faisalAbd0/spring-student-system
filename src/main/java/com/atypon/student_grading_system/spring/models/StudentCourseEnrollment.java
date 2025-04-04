package com.atypon.student_grading_system.spring.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentCourseEnrollment {
    @EmbeddedId
    private StudentCourseEnrolmentId id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    @JsonIgnore
    private StudentSpring student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    @JsonIgnore
    private CourseSpring course;

    private double grade;

    public StudentCourseEnrollment(Long studentId, Long courseId, double grade) {
        this.id = new StudentCourseEnrolmentId(studentId, courseId);
        this.grade = grade;
    }
}
