package com.example.demo;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;
    private final String email;
    private final LocalDate dateOfBirth;
    
    private String nickname;
    private String password;
    private String phone;
    private String type;
    private Boolean deleted = false;
    private String code;

    public User(Long id, String email, LocalDate dateOfBirth) {
      this.id = id;
      this.email = email;
      this.dateOfBirth = dateOfBirth;
    }

    
    // Getters and setters
    
    //Getters for immutable data
    public Long getId() { return id; }
    public String getEmail() { return email; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    
    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    
    public Boolean getDeleted() { return deleted; }
    public void setDeleted(Boolean deleted) { this.deleted = deleted; }
    
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public void updateUserInfo(String newNickname, String newPassword, String newPhone) {
      if(newNickname != null) {
         setNickname(newNickname);
      }
 
      if(newPassword != null) {
         setPassword(newPassword);
      }
 
      if(newPhone != null) {
         setPhone(newPhone);
      }
    }

   }