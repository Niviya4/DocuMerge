package com.example.collabdoc.controller;

import com.example.collabdoc.model.User;
import com.example.collabdoc.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestParam String email, @RequestParam String password, @RequestParam String role) {
        authService.registerUser(email, password, role);
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/user")
    public ResponseEntity<Optional<User>> getUser(@RequestParam String email) {
        return ResponseEntity.ok(authService.findByEmail(email));
    }
}