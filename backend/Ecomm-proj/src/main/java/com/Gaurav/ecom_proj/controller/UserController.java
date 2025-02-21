package com.Gaurav.ecom_proj.controller;

import com.Gaurav.ecom_proj.Security.JwtUtil;
import com.Gaurav.ecom_proj.model.User;

import com.Gaurav.ecom_proj.service.UserService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil; // Inject JwtUtil to generate token

    // Sign up a new user
    @PostMapping("/signup")
    public ResponseEntity<?> SignUpUser(@RequestBody User user) {
        try {
            String hashedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashedPassword);
            User user1 = service.addUser(user);
            return new ResponseEntity<>(user1, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("User Already Exists", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Log in and generate JWT token
    @PostMapping("/login")
    public ResponseEntity<?> LogInUser(@RequestBody User user) {
        try {
            String userName = user.getUsername();
            User user1 = service.getUserByName(userName);

            // Check if username exists
            if (user1 == null) {
                return new ResponseEntity<>("User Not Found", HttpStatus.BAD_REQUEST);
            }

            String hashedPassword = user1.getPassword();
            String password = user.getPassword();

            // Check if password matches
            if (!passwordEncoder.matches(password, hashedPassword)) {
                return new ResponseEntity<>("Password Does Not Match", HttpStatus.BAD_REQUEST);
            }

            String role = user1.getRole().toString();  // Assuming getRole() returns an enum

            // Generate JWT token after successful login
            String token = jwtUtil.generateToken(user1.getUsername(), role);

            // Return the token along with user details
            return ResponseEntity.ok(new AuthResponse(token)); // Custom response object with token

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Custom class to return JWT token

    public static class AuthResponse {
        private String token;

        public AuthResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }

    @PostMapping("/verifytoken")
    public ResponseEntity<?> VerifyToken(@RequestBody String jwttoken){

        jwtUtil.validateToken(jwttoken,);
    }
}
