package com.example.BearerAuth.Controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/secure")
    public String secureEndpoint() {
        return "You are authenticated!";
    }
}
