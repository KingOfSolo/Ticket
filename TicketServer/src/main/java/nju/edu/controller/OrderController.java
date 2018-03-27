package nju.edu.controller;

import nju.edu.model.Order;
import nju.edu.repositoty.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by xiaoJun on 2018/3/26.
 */
@RestController
@RequestMapping(value = "/Order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(value = "/confirm", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Order confirm(@RequestBody Order order){
        Date date = new Date();
        order.setDate(date);
        order.setNumber(date.getTime());
        return orderRepository.save(order);
    }
}
