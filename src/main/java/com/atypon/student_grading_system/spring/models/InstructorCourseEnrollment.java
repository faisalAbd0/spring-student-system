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
public class InstructorCourseEnrollment  {
    @EmbeddedId
    private InstructorCourseEnrollmentId id;

    @ManyToOne
    @MapsId("instructorId")
    @JoinColumn(name = "instructor_Id", insertable = false, updatable = false)
    @JsonIgnore
    private InstructorSpring instructor;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    @JsonIgnore
    private CourseSpring course;


}
