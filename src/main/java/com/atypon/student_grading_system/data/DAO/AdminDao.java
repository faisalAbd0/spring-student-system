//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.atypon.student_grading_system.data.DAO;

import com.atypon.student_grading_system.models.Admin;

public interface AdminDao {
    void createAdmin(Admin admin);

    void deleteAdmin(int adminId);

    Admin getAdmin(String username);
}
