package nju.edu.controller;

import nju.edu.model.User;
import nju.edu.service.UserService;
import nju.edu.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/findById/id/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable("id")String id){
        return userService.findById(Integer.parseInt(id));
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(HttpServletRequest request){
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        return userService.registerUser(user);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public String login(HttpServletRequest request){
         return null;
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
