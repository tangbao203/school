package org.example.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = {"org.example.common.inf"})
@SpringBootApplication
public class StudentApp {

    public static void main(String[] args){
        SpringApplication.run(StudentApp.class,args);
    }

}
