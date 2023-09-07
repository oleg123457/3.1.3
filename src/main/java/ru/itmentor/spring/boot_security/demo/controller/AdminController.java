package ru.itmentor.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itmentor.spring.boot_security.demo.Models.User;
import ru.itmentor.spring.boot_security.demo.Service.UserServiceImp;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final UserServiceImp userService;

    @Autowired
    public AdminController(UserServiceImp userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("user/{id}")
    public User getUserById(@PathVariable("id") int id) {

        return userService.getUserById(id);
    }

    @PostMapping()
    public List<User> create(@RequestBody User user) {
        userService.save(user);
        return userService.getAllUsers();
    }

    @PatchMapping("/{id}")
    public List<User> update(@RequestBody User user, @PathVariable("id") int id) {
        userService.update(id, user);
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public List<User> delete(@PathVariable("id") int id) {
        userService.delete(id);
        return userService.getAllUsers();
    }
}