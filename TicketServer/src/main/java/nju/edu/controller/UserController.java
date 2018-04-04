package nju.edu.controller;

import nju.edu.model.User;
import nju.edu.repositoty.UserRepository;
import nju.edu.service.UserService;
import nju.edu.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by xiaoJun on 2018/3/1.
 */
@RestController
@RequestMapping(value = "/User")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/findById/id/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable("id")String id){
        return userService.findById(Integer.parseInt(id));
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String register(@RequestBody User user){
        return userService.registerUser(user);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public User login(@RequestBody User user){
         return userService.login(user.getEmail(), user.getPassword());
    }

    @RequestMapping(value = "/verify/id/{id}",method = RequestMethod.GET)
    public String verify(@PathVariable("id") int id){
        User user = userService.findById(id);
        user.setState(1);
        userRepository.save(user);
        return "验证成功";
    }

    @RequestMapping(value="/modify",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public User modify(@RequestBody User user){
        return userRepository.save(user);
    }

    @RequestMapping(value="/frozen/{id}",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public User frozen(@PathVariable("id") int id){
        User user = userRepository.findOne(id);
        user.setState(2);
        return userRepository.save(user);
    }

    /**
     * 获取用户折扣
     * @param id
     * @return
     */
    @RequestMapping(value = "/discount/{id}",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public double discount(@PathVariable("id") int id){
        return userService.discount(id);
    }

    @RequestMapping(value = "/hello", produces="application/json;charset=UTF-8")
    public String hello() {
        ArrayList<String> users =  new ArrayList<String>(){{ add("hello"); }};
        return JSONResult.fillResultString(0, "", users);
    }


    @RequestMapping(value = "/world", produces="application/json;charset=UTF-8")
    public String world() {
        ArrayList<String> users =  new ArrayList<String>(){{ add("world"); }};
        return JSONResult.fillResultString(0, "", users);
    }
}
