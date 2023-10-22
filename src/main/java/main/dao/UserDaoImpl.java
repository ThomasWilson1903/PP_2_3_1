package main.dao;

import main.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManagers;

    @Override
    public List<User> getAllUsers() {
        return entityManagers.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUser(int id) {
        return entityManagers.find(User.class, id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManagers.merge(user);
        entityManagers.flush();
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        entityManagers.remove(entityManagers.find(User.class, id));
    }
}
