package nju.edu.service;

import nju.edu.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by xiaoJun on 2018/3/1.
 */
public interface UserService {
    User findById(int id);

    String registerUser(User user);

    User login(String email, String password);

    User findByNameAndPassword(String name, String password);

    double discount(int id);
}
