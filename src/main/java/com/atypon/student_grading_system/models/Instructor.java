//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.atypon.student_grading_system.models;

public class Instructor extends IUser {
    public static Instructor createInstructor(String username, String password) {
        return new Instructor(username, password);
    }

    private Instructor(String username, String password) {
        super(username, password);
    }

    public String toString() {
        return "Instructor: id=" + this.id + ", username=" + this.username + ", password=" + this.password;
    }
}
