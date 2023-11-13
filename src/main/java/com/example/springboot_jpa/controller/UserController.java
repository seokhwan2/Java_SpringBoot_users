package com.example.springboot_jpa.controller;

import com.example.springboot_jpa.entity.Users;
import com.example.springboot_jpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/users")
    public List<Users> getUsers(@RequestParam(required = false, defaultValue = "") String name){
        return userService.getUserService(name);
    }

    @PostMapping(value = "/user", produces = "application/json")
    public String createUser(@RequestBody Users user){
        return userService.createUserService(user);
    }

}
