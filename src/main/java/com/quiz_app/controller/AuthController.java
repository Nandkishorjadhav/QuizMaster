package com.quiz_app.controller;

import com.quiz_app.dto.UserDTO;
import com.quiz_app.model.User;
import com.quiz_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    public String signup(@RequestBody UserDTO userDTO) {
        if (userDTO == null || userDTO.getEmail() == null || userDTO.getPassword() == null || userDTO.getRole() == null) {
            return "Invalid signup data!";
        }

        Optional<User> existingUser = userRepository.findByEmail(userDTO.getEmail());
        if (existingUser.isPresent()) {
            return "Email already exists!";
        }

        User newUser = new User();
        newUser.setName(userDTO.getName());
        newUser.setEmail(userDTO.getEmail());
        newUser.setPassword(userDTO.getPassword());
        newUser.setRole(userDTO.getRole());

        User savedUser = userRepository.save(newUser);

        System.out.println("✅ Saved User: " + savedUser);

        return "Signup successful!";
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
        if (userDTO == null || userDTO.getEmail() == null || userDTO.getPassword() == null) {
            return ResponseEntity.badRequest().body(Map.of("message", "Invalid login data!"));
        }

        String inputEmail = userDTO.getEmail().trim();
        String inputPassword = userDTO.getPassword().trim();

        Optional<User> user = userRepository.findByEmail(inputEmail);
        if (user.isPresent()) {
            String storedPassword = user.get().getPassword().trim();

            System.out.println("Attempt login for: " + inputEmail);
            System.out.println("Input password: " + inputPassword);
            System.out.println("Stored password: " + storedPassword);

            if (storedPassword.equals(inputPassword)) {
                String role = user.get().getRole();
                String redirect = role.equalsIgnoreCase("student") ? "student-dashboard" : "faculty-dashboard";

                return ResponseEntity.ok(Map.of(
                        "message", "Login successful!",
                        "email", user.get().getEmail(),
                        "name", user.get().getName(),
                        "role", role,
                        "redirect", redirect
                ));
            } else {
                return ResponseEntity.status(401).body(Map.of("message", "Incorrect password!"));
            }
        }

        return ResponseEntity.status(401).body(Map.of("message", "Email not found!"));
    }

}
