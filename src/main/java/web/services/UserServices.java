package web.services;

import web.models.User;

import java.util.List;

public interface UserServices {
        List<User> getAllUsers();
        User getUser(int id);
        void saveUser(User user);
        void delUser(int id);
}
