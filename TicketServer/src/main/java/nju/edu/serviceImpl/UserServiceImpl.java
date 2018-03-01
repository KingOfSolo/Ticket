package nju.edu.serviceImpl;

import nju.edu.dao.UserDao;
import nju.edu.model.User;
import nju.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by xiaoJun on 2018/3/1.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public User findById(int id) {
        return this.userDao.findById(id).get(0);
    }
}
