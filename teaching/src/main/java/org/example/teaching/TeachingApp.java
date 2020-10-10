package org.example.teaching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = {"org.example.common.inf"})
@SpringBootApplication
public class TeachingApp {
    public static void main(String[] args){
        SpringApplication.run(TeachingApp.class,args);
    }
}
