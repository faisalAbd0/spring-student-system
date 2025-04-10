//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.atypon.student_grading_system.models;

public class Student extends IUser {
    private int age;
    private double gpa;

    private Student(String username, String password, int age, double gpa, int id) {
        super(username, password);
        super.id = id;
        this.age = age;
        this.gpa = gpa;
    }

    public int getAge() {
        return this.age;
    }

    public double getGpa() {
        return this.gpa;
    }

    public String toString() {
        return "Student{username='" + this.username + "', id=" + this.id + ", gpa=" + this.gpa + ", age=" + this.age + ", password='" + this.password + "'}";
    }

    public static class Builder {
        private int id;
        private int age;
        private double gpa;
        private String username;
        private String password;

        public Builder() {
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setGpa(double gpa) {
            this.gpa = gpa;
            return this;
        }

        public Student build() {
            return new Student(this.username, this.password, this.age, this.gpa, this.id);
        }
    }
}
