package com.quiz_app.controller;

import com.quiz_app.dto.UserDTO; // Assuming you created a DTO
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO user) {
        // logic to validate login
        return ResponseEntity.ok("Login success!");
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserDTO user) {
        // logic to save user
        return ResponseEntity.ok("Signup success!");
    }
}

