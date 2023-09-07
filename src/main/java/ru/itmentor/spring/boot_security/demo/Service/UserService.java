package ru.itmentor.spring.boot_security.demo.Service;


import ru.itmentor.spring.boot_security.demo.Models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(int id);

    void save(User user);

    void update(int id, User updateUser);

    void delete(int id);
}
