//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.atypon.student_grading_system.data.MySqlDao;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class MySQLConnection implements Closeable {
    private static final String URL = "jdbc:mysql://localhost:3306/student_system";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    private static Connection instance;

    private MySQLConnection() {
    }

    public static Connection getConnection() {
        if (instance == null) {
            try {
                synchronized(MySQLConnection.class) {
                    instance = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_system", "root", "123456");
                }

                System.out.println("✅ Connected to MySQL successfully!");
            } catch (SQLException e) {
                throw new RuntimeException("❌ Failed to connect to MySQL", e);
            }
        }

        return instance;
    }

    public void close() throws IOException {
        if (instance != null) {
            try {
                instance.close();
                System.out.println("✅ MySQL connection closed.");
            } catch (SQLException e) {
                throw new RuntimeException("❌ Failed to close MySQL connection", e);
            } finally {
                instance = null;
            }
        }

    }
}
