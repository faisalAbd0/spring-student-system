//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.atypon.student_grading_system.Socket.userHandler;

import com.atypon.student_grading_system.models.IUser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public interface UserHandler {
    void handleUserRequest(IUser user, PrintWriter out, BufferedReader in) throws IOException;
}
