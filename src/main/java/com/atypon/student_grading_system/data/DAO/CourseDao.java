//// Source code recreated from a .class file by IntelliJ IDEA// (powered by FernFlower decompiler)//package com.atypon.student_grading_system.data.DAO;import com.atypon.student_grading_system.models.Course;import java.util.List;public interface CourseDao {    void addCourse(Course course);    void deleteCourse(int courseId);    List<Course> getStudentCourseById(int studentId);    Course getCourseById(int courseId);    List<Integer> getCourseStatus(int courseId);    List<Course> getAllCourses();}