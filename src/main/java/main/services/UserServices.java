package main.services;

import main.model.User;

import java.util.List;

public interface UserServices {
    List<User> getAllUsers();
    User getUser(int id);
    void saveUser(User user);
    void deleteUser(int id);
}
