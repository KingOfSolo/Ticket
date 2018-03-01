package nju.edu;

import nju.edu.model.User;
import nju.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaoJun on 2018/1/31.
 */
@RestController
public class Test {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/test/id/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable("id")String id){
        return userService.findById(Integer.parseInt(id));
    }

    @RequestMapping(value = "/test2",method = RequestMethod.GET)
    public String test2(){
        System.out.println("hello");
        return "hello";
    }
}
