package com.example.demo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
@RestController
public class DemoApplication {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hi Friend %s!", name);
    }

    // ✅ Create the first user if no users exist
    @PostMapping("/user/create-first")
    public String createFirstUser() {
        if (userRepository.count() > 0) {
            return "User already exists!";
        }

        User user = new User(1L, "admin@example.com", LocalDate.of(2001, 1, 1));
        user.setNickname("admin");
        user.setPassword("encrypted-password");
        user.setType("Super Admin");
        user.setCode("INIT-001");

        userRepository.save(user);
        return "First user created successfully!";
    }

    // ✅ Retrieve the first user
    @GetMapping("/user/first")
    public ResponseEntity<?> getFirstUser() {
        var users = userRepository.findAll();
        if (users.isEmpty()) {
            return ResponseEntity.ok("No users found!");
        }
        return ResponseEntity.ok(users.get(0));
    }
}