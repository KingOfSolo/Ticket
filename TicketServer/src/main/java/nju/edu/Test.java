package nju.edu;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaoJun on 2018/1/31.
 */
@RestController
public class Test {

    @RequestMapping(value = "/",method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String index(){
        return "Hello Spring Boot!";
    }
}
