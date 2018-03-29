package nju.edu.controller;

import nju.edu.model.Order;
import nju.edu.repositoty.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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

    @RequestMapping(value = "findByUserId/id/{id}",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<Order> findByUserId(@PathVariable("id") int id){
        return orderRepository.findByBuyer(id);
    }
}
