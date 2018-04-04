package nju.edu.serviceImpl;

import nju.edu.dao.UserDao;
import nju.edu.model.User;
import nju.edu.repositoty.UserRepository;
import nju.edu.service.MailService;
import nju.edu.service.UserService;
import nju.edu.util.Member;
import nju.edu.util.UserDiscount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by xiaoJun on 2018/3/1.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailService mailService;

    @Override
    public User findById(int id) {
        return this.userDao.findById(id).get(0);
    }

    @Override
    public String registerUser(User user) {
        user.setLevel(1);
        user.setBalance(1000);
        userRepository.save(user);
        List<User> list = userRepository.findAll();
        String link = "localhost:8075/TicketServer/User/verify/id/"+list.get(list.size()-1).getId();
        String content = "<html><body>" +
                "<p>"+user.getName()+",您好!</p>" +
                "<div>请点击下面的链接完成注册，若无法访问，请复制下面的的链接到地址栏</div>"+
                "<a href=\""+link+"\">"+link+"</a>"+
                "</body></html>";
        mailService.SendHtmlMail(user.getEmail(), "邮箱验证", content);
        return "";
    }

    @Override
    public User login(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        if(user != null && user.getState() == 1){
            return user;
        }
        return null;
    }

    @Override
    public User findByNameAndPassword(String name, String password) {
        return this.userDao.findByNameAndPassword(name, password).get(0);
    }

    @Override
    public double discount(int id) {
        User user = userRepository.findOne(id);
        return discountCheck(user.getLevel());
    }
    
    private double discountCheck(int level){
        if (1 <= level && level < 2){
            return UserDiscount.DISCOUNT_1;
        }else if(2 <= level && level < 3){
            return UserDiscount.DISCOUNT_2;
        }else if(3 <= level && level < 4){
            return UserDiscount.DISCOUNT_3;
        }else if(4 <= level && level < 5){
            return UserDiscount.DISCOUNT_4;
        }else if(5 <= level && level < 6){
            return UserDiscount.DISCOUNT_5;
        }else if(6 <= level && level < 7){
            return UserDiscount.DISCOUNT_6;
        }else if(7 <= level && level < 8){
            return UserDiscount.DISCOUNT_7;
        }else if(8 <= level && level < 9){
            return UserDiscount.DISCOUNT_8;
        }else{
            return UserDiscount.DISCOUNT_9;
        }
    }
}
