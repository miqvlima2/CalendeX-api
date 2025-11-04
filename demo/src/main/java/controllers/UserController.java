package controllers;

import com.example.demo.User;
import services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/users")
public class UserController {

   private final UserService userService;
   public UserController(UserService userService) {
         this.userService = userService;
   }

    @GetMapping("/hello") //@todo colocar todas urls em um arquivo só
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hi my friend Adilson %s!", name);
    }

    @GetMapping("/id")
    public User getUserById(@RequestParam(value = "id") Long id) {
        return userService.getUserById(id);
    }

    public static void main(String[] args) {
        SpringApplication.run(UserController.class, args);
    }
}