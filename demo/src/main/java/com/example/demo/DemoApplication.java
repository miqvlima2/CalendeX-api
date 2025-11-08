package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// ✅ This is now your main class for starting Spring Boot
@SpringBootApplication(scanBasePackages = {
    "com.example.demo", // base package
    "controllers",
    "services",
    "requests",
    "validators"
})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}