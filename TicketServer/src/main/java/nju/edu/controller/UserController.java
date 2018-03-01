package nju.edu.controller;

import nju.edu.model.User;
import nju.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
