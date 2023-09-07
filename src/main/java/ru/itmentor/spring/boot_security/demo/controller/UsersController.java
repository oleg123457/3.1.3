package ru.itmentor.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmentor.spring.boot_security.demo.Models.User;
import ru.itmentor.spring.boot_security.demo.Service.UserServiceImp;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UsersController {
    private final UserServiceImp userService;

    @Autowired
    public UsersController(UserServiceImp userService) {
        this.userService = userService;
    }

    @GetMapping()
    public User getUserById(Principal principal) {

        return (User) userService.loadUserByUsername(principal.getName());
    }
}
