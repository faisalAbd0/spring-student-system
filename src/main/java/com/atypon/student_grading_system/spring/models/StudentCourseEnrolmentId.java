package com.atypon.student_grading_system.spring.models;


import jakarta.persistence.Embeddable;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class StudentCourseEnrolmentId {
    private Long studentId;
    private Long courseId;
}
