//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.atypon.student_grading_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ServletComponentScan(
        basePackages = {"com.atypon.student_grading_system.servlet_jsp"}
)
@SpringBootApplication
public class StudentGradingSystemApplication {
    public StudentGradingSystemApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(StudentGradingSystemApplication.class, args);
    }

    @Configuration
    public static class WebConfig implements WebMvcConfigurer {
        public WebConfig() {
        }

        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler(new String[]{"/css/**"}).addResourceLocations(new String[]{"classpath:/css/"});
        }
    }
}
