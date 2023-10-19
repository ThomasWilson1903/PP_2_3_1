package web.services;

import web.dao.UserDAO;
import web.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class SevicesUser implements UserServices {
    @Autowired
    private UserDAO userDAO;


    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User getUser(int id) {
        return userDAO.getUser(id);
    }
    @Transactional
    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }
    @Transactional
    @Override
    public void delUser(int id) {
        userDAO.delUser(id);
    }

}
