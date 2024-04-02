package com.fan.service_teacher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = {"com.fan"})
public class ServiceTeacherApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ServiceTeacherApplication.class, args);
    }
}
