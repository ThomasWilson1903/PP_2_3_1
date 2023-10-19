package dao;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDAO {

    private EntityManager entityManager;

    @Autowired
    public UserDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }
}
