package nju.edu.daoImpl;

import nju.edu.dao.UserDao;
import nju.edu.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by xiaoJun on 2018/2/28.
 */
@Repository
public class UserDaoImpl{

    @PersistenceContext
    private EntityManager entityManager;

    private static UserDaoImpl userDao = new UserDaoImpl();

    public User getUserInfo(String id) {
        User user = this.entityManager.find(User.class, Integer.parseInt(id));
        return user;
    }
}
