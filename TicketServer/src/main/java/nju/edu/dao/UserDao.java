package nju.edu.dao;

import nju.edu.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by xiaoJun on 2018/2/28.
 */
public interface UserDao extends JpaRepository<User,Integer>{

    List<User> findById(int id);
}
