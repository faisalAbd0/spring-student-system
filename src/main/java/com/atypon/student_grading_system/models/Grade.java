//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.atypon.student_grading_system.models;

public class Grade {
    private int grade;
    private Course course;
    private int studentId;

    private Grade(int grade, Course course, int student) {
        this.grade = grade;
        this.course = course;
        this.studentId = student;
    }

    public static Grade createGrade(int grade, Course course, int student) {
        return new Grade(grade, course, student);
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Course getCourse() {
        return this.course;
    }

    public int getGrade() {
        return this.grade;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public String toString() {
        int var10000 = this.grade;
        return "Grade{grade=" + var10000 + ", course=" + String.valueOf(this.course) + ", studentId=" + this.studentId + "}";
    }
}
