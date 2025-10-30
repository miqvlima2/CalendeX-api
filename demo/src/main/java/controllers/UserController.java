package controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class UserController {
    @GetMapping("/hello") //@todo colocar todas urls em um arquivo só
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hi my friend Adilson %s!", name);
    }

    public static void main(String[] args) {
        SpringApplication.run(UserController.class, args);
    }
}