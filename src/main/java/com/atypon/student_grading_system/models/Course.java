//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.atypon.student_grading_system.models;

public class Course {
    private int courseId;
    private String courseName;
    private int studentLimit;

    private Course(String courseName, int studentLimit) {
        this.courseName = courseName;
        this.studentLimit = studentLimit;
    }

    public static Course createCourse(String courseName, int studentLimit) {
        return new Course(courseName, studentLimit);
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public int getStudentLimit() {
        return this.studentLimit;
    }

    public void setStudentLimit(int studentLimit) {
        this.studentLimit = studentLimit;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getCourseId() {
        return this.courseId;
    }

    public String toString() {
        return "Course{courseId=" + this.courseId + ", courseName='" + this.courseName + "', studentLimit=" + this.studentLimit + "}";
    }
}
