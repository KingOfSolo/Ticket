package nju.edu.controller;

import nju.edu.model.Order;
import nju.edu.model.Seat;
import nju.edu.model.ShowPrice;
import nju.edu.repositoty.OrderRepository;
import nju.edu.repositoty.SeatRepository;
import nju.edu.repositoty.ShowPriceRepository;
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

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private ShowPriceRepository showPriceRepository;

    @RequestMapping(value = "/confirm", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Order confirm(@RequestBody Order order){
        Date date = new Date();
        order.setDate(date);
        order.setNumber(date.getTime());
        return orderRepository.save(order);
    }

    @RequestMapping(value = "userId/{userId}",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<Order> findByUserId(@PathVariable("userId") int id){
        return orderRepository.findByBuyer(id);
    }

    @RequestMapping(value = "number/{number}",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public Order findByNumber(@PathVariable("number") Long number){
        return orderRepository.findByNumber(number).get(0);
    }

    @RequestMapping(value = "seat/{seatId}",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ShowPrice getSeat(@PathVariable("seatId") int seatId){
        return showPriceRepository.findOne(seatId);
    }

    /**
     * 获取系统当前时间
     * @return 系统当前时间
     */
    @RequestMapping(value = "time/now",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public Date nowTime(){
        return new Date();
    }
}
