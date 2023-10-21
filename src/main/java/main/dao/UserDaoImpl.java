package main.dao;

import main.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    private EntityManager entityManagers;


    @Override
    public List<User> getAllUsers() {
        return entityManagers.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public void saveUser(User user) {
        entityManagers.merge(user);
    }

    @Override
    public void deleteUser(int id) {
        entityManagers.remove(new User(id));
    }
}
