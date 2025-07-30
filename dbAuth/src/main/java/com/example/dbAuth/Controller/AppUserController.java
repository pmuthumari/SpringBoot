package com.example.dbAuth.Controller;


import com.example.dbAuth.Entity.AppUser;
import com.example.dbAuth.Repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class AppUserController {

    @Autowired
    private AppUserRepository repo;

    @GetMapping
    public List<AppUser> getAllUsers() {
        return repo.findAll();
    }

    @PostMapping
    public AppUser createUser(@RequestBody AppUser user) {
        return repo.save(user);
    }
}

