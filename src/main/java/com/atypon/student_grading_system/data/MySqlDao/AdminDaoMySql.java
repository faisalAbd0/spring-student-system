//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.atypon.student_grading_system.data.MySqlDao;

import com.atypon.student_grading_system.data.DAO.AdminDao;
import com.atypon.student_grading_system.models.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoMySql implements AdminDao {
    private final Connection connection = MySQLConnection.getConnection();
    private static AdminDaoMySql adminDaoMySql;

    private AdminDaoMySql() {
    }

    public static AdminDaoMySql getInstance() {
        if (adminDaoMySql == null) {
            adminDaoMySql = new AdminDaoMySql();
        }

        return adminDaoMySql;
    }

    public void createAdmin(Admin admin) {
        String sqlQuery = "insert into admin(username, password) values(?, ?)";

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, admin.getUsername());
            preparedStatement.setString(2, admin.getPassword());
            int res = preparedStatement.executeUpdate();
            if (res > 0) {
                System.out.println("Admin created successfully");
            } else {
                System.out.println("Admin creation failed");
            }
        } catch (SQLException e) {
            System.out.println("Admin creation failed");
            e.printStackTrace();
        }

    }

    public void deleteAdmin(int adminId) {
        String sqlQuery = "delete from admin where id = ?";

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, adminId);
            int res = preparedStatement.executeUpdate();
            if (res > 0) {
                System.out.println("Admin deleted successfully");
            } else {
                System.out.println("Admin deletion failed");
            }
        } catch (SQLException e) {
            System.out.println("Admin deletion failed");
            e.printStackTrace();
        }

    }

    public Admin getAdmin(String username) {
        Admin admin = null;
        String query = "select * from admin where username = ?";

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                admin = Admin.createAdmin(resultSet.getString("username"), resultSet.getString("password"));
                admin.setId(resultSet.getInt("id"));
                return admin;
            }
        } catch (SQLException e) {
            System.out.println("Admin getting failed");
            e.printStackTrace();
        }

        return null;
    }
}
