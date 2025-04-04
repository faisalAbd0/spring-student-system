package com.atypon.student_grading_system.spring.conf;


import com.atypon.student_grading_system.spring.models.CourseSpring;
import com.atypon.student_grading_system.spring.models.InstructorSpring;
import com.atypon.student_grading_system.spring.models.StudentSpring;
import com.atypon.student_grading_system.spring.repos.CourseRepo;
import com.atypon.student_grading_system.spring.repos.InstructorRepo;
import com.atypon.student_grading_system.spring.repos.StudentRepo;
import com.atypon.student_grading_system.spring.service.InstructorCourseEnrollmentService;
import com.atypon.student_grading_system.spring.service.StudentCourseEnrollmentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class Config {
    @Bean
    CommandLineRunner commandLineRunner2(CourseRepo courseRepo ,
                                         StudentRepo studentRepo ,
                                         InstructorRepo instructorRepo,
                                         StudentCourseEnrollmentService studentEnrollment,
                                         InstructorCourseEnrollmentService courseEnrollment

    ) {
        return args -> {
            CourseSpring java = new CourseSpring("JAVA 101" , 30);
            CourseSpring python = new CourseSpring("Python 101" , 30);
            courseRepo.save(java);
            courseRepo.save(python);


            StudentSpring faisal = new StudentSpring("Faisal" , "$2a$12$pAq4PnXQDv75vcDrlUxafeVVbXRcnC9y3wK3xGYbCjl9eG/NKNiB2"  , 3.4 ,
                    LocalDate.of(2000 , Month.JANUARY ,5));
            StudentSpring alex = new StudentSpring("Alex" , "$2a$12$pAq4PnXQDv75vcDrlUxafeVVbXRcnC9y3wK3xGYbCjl9eG/NKNiB2" , 3.6 ,
                    LocalDate.of(1900 , Month.JANUARY ,5));
            studentRepo.save(alex);
            studentRepo.save(faisal);

            InstructorSpring instructor = new InstructorSpring("faisalIn" , "$2a$12$pAq4PnXQDv75vcDrlUxafeVVbXRcnC9y3wK3xGYbCjl9eG/NKNiB2");
            instructorRepo.save(instructor);



            studentEnrollment.enrollStudent(faisal.getId(),java.getId(),33);
            studentEnrollment.enrollStudent(faisal.getId(),python.getId(),44);
            studentEnrollment.enrollStudent(alex.getId(),python.getId(),54);

            courseEnrollment.enrollInstructor(instructor.getId(),java.getId());
            courseEnrollment.enrollInstructor(instructor.getId(),python.getId());



        };
    }

}
