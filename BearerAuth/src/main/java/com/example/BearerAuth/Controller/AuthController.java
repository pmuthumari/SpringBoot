package com.example.BearerAuth.Controller;


import com.example.BearerAuth.Entity.User;
import com.example.BearerAuth.JWT.JwtUtil;
import com.example.BearerAuth.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository repo;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        repo.save(user);
        return "User registered!";
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user) {
        Optional<User> found = repo.findByUsername(user.getUsername());
        if (found.isPresent() && found.get().getPassword().equals(user.getPassword())) {
            String token = jwtUtil.generateToken(user.getUsername());
            return Map.of("token", token);
        }
        throw new RuntimeException("Invalid credentials");
    }
}
