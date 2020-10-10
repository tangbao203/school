package org.example.teacher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableFeignClients(basePackages = {"org.example.common.inf"})
@SpringBootApplication
public class TeacherApp {
    public static void main(String[] args){
        SpringApplication.run(TeacherApp.class,args);
    }
}
