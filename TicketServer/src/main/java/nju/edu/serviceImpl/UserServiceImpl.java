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

    @Override
    public String registerUser(User user) {
        if(userDao.findByName(user.getName()).isEmpty()){
            this.userDao.save(user);
            return "用户名 " + user.getName() + "注册成功";
        }else {
            return "用户名 " + user.getName() + "已被占用!";
        }

    }

    @Override
    public User login(String name, String password) {
        User user = userDao.findByNameAndPassword(name, password).get(0);
        if(user == null){

        }
        return null;
    }

    @Override
    public User findByNameAndPassword(String name, String password) {
        return this.userDao.findByNameAndPassword(name, password).get(0);
    }
}
