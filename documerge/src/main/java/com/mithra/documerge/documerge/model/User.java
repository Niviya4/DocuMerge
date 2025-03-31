package com.mithra.documerge.documerge.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String role; // OWNER, EDITOR, VIEWER

<<<<<<< HEAD
    public User() {}

    // Getters and Setters
=======
    // Manually added getter and setter methods
>>>>>>> 68b798e63662e3383aa597f81aa45a159a91ecc9
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
<<<<<<< HEAD
}
=======
}
>>>>>>> 68b798e63662e3383aa597f81aa45a159a91ecc9
