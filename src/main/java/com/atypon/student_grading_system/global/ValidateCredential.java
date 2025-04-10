//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.atypon.student_grading_system.global;

import com.atypon.student_grading_system.data.DAO.AdminDao;
import com.atypon.student_grading_system.data.DAO.InstructorDao;
import com.atypon.student_grading_system.data.DAO.StudentDao;
import com.atypon.student_grading_system.data.MySqlDao.AdminDaoMySql;
import com.atypon.student_grading_system.data.MySqlDao.InstructorDaoMySql;
import com.atypon.student_grading_system.data.MySqlDao.StudentDaoMySql;
import com.atypon.student_grading_system.models.Admin;
import com.atypon.student_grading_system.models.IUser;
import com.atypon.student_grading_system.models.Instructor;
import com.atypon.student_grading_system.models.Student;
import com.atypon.student_grading_system.models.USER;
import java.util.Optional;

public class ValidateCredential {
    static StudentDao studentDao = StudentDaoMySql.getInstance();
    static InstructorDao instructorDao = InstructorDaoMySql.getInstance();
    static AdminDao adminDao = AdminDaoMySql.getInstance();

    public ValidateCredential() {
    }

    private static IUser getUserByType(String username, USER userType) {
        Object var10000;
        switch (userType) {
            case STUDENT -> var10000 = studentDao.getStudentByUsername(username);
            case INSTRUCTOR -> var10000 = instructorDao.getInstructor(username);
            case ADMIN -> var10000 = adminDao.getAdmin(username);
            default -> throw new MatchException((String)null, (Throwable)null);
        }

        return (IUser)var10000;
    }

    private static String getUserPassword(IUser user) {
        if (user instanceof Student student) {
            return student.getPassword();
        } else if (user instanceof Instructor instructor) {
            return instructor.getPassword();
        } else if (user instanceof Admin admin) {
            return admin.getPassword();
        } else {
            return null;
        }
    }

    public static Optional<IUser> checkUserCredentials(String username, String password, USER userType) {
        IUser user = getUserByType(username, userType);
        if (user == null) {
            return Optional.empty();
        } else {
            String originalPassword = getUserPassword(user);
            return originalPassword != null && originalPassword.equals(password) ? Optional.of(user) : Optional.empty();
        }
    }
}
