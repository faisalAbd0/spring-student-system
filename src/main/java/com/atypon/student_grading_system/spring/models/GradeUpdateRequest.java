package com.atypon.student_grading_system.spring.models;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GradeUpdateRequest {
    private double newGrade;
    private Long courseId;
    private Long studentId;
}
