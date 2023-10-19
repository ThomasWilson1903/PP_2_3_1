package web.dao;

import web.models.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    User getUser(int id);
    void saveUser(User user);
    void delUser(int id);
}
