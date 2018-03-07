package nju.edu.dao;

import nju.edu.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xiaoJun on 2018/2/28.
 */
@Repository
public interface UserDao extends JpaRepository<User,Integer>{

    List<User> findById(int id);

    User save(User user);

    List<User> findByName(String name);

    List<User> findByNameAndPassword(String name, String password);

    List<User> findByEmail(String email);
}
