//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.atypon.student_grading_system.data.DAO;

import com.atypon.student_grading_system.models.Course;
import com.atypon.student_grading_system.models.Instructor;
import java.util.List;

public interface InstructorDao {
    void createInstructor(Instructor instructor);

    void deleteInstructor(int instructorId);

    Instructor getInstructor(String username);

    List<Course> getInstructorCourses(int instructorId);

    List<Instructor> getInstructors();
}
