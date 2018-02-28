package nju.edu;

import nju.edu.factory.DaoFactory;
import nju.edu.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaoJun on 2018/1/31.
 */
@RestController
public class Test {

    @RequestMapping(value = "/test",method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public User index(){
        System.out.println("hello");
        return DaoFactory.getUserDao().getUserInfo("1");
    }
}
