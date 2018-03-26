package nju.edu.serviceImpl;

import nju.edu.dao.UserDao;
import nju.edu.model.User;
import nju.edu.repositoty.UserRepository;
import nju.edu.service.MailService;
import nju.edu.service.UserService;
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
}
