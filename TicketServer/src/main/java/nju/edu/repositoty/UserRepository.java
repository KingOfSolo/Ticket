package nju.edu.repositoty;

import nju.edu.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by xiaoJun on 2018/3/25.
 */
public interface UserRepository extends JpaRepository<User, Integer>{
    User findByEmailAndPassword(String email, String password);

    User findOne(int id);

    List<User> findByState(int state);
}
