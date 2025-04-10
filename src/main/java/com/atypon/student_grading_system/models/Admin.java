//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.atypon.student_grading_system.models;

public class Admin extends IUser {
    public static Admin createAdmin(String username, String password) {
        return new Admin(username, password);
    }

    private Admin(String username, String password) {
        super(username, password);
    }

    public String toString() {
        return "Admin: id=" + this.id + ", username=" + this.username + ", password=" + this.password;
    }
}
