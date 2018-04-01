package nju.edu.controller;

import nju.edu.model.Order;
import nju.edu.model.Seat;
import nju.edu.model.ShowPrice;
import nju.edu.repositoty.OrderRepository;
import nju.edu.repositoty.SeatRepository;
import nju.edu.repositoty.ShowPriceRepository;
import nju.edu.service.OrderService;
import nju.edu.util.OrderState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
    private ShowPriceRepository showPriceRepository;

    @Autowired
    private OrderService orderService;

    /**
     * 确认订单
     * @param order
     * @return
     */
    @RequestMapping(value = "/confirm", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Order confirm(@RequestBody Order order){
       return orderService.confirm(order);
    }

    /**
     * 根据用户id获取订单列表
     * @param id
     * @return
     */
    @RequestMapping(value = "userId/{userId}",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<Order> findByUserId(@PathVariable("userId") int id){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return orderRepository.findByBuyer(id, sort);
    }

    /**
     * 根据订单号获取订单信息
     * @param number
     * @return
     */
    @RequestMapping(value = "number/{number}",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public Order findByNumber(@PathVariable("number") Long number){
        return orderRepository.findByNumber(number).get(0);
    }

    /**
     * 根据座位id获取座位信息
     * @param seatId
     * @return
     */
    @RequestMapping(value = "seat/{seatId}",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ShowPrice getSeat(@PathVariable("seatId") int seatId){
        return showPriceRepository.findOne(seatId);
    }

    @RequestMapping(value = "pay/{number}",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public void orderPay(@PathVariable("number") Long number){
        orderService.orderPay(number);
    }

    @RequestMapping(value = "fail/{number}", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public void payFail(@PathVariable("number") Long number){
    }

    /**
     * 退订
     * @param number
     */
    @RequestMapping(value = "refund/{number}",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public void refund(@PathVariable("number") Long number){
        System.out.println(number);
        orderService.refund(number);
    }

    /**
     * 用户消费的总和
     * @param buyer
     * @return
     */
    @RequestMapping(value = "consumption/{buyer}",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public int consumption(@PathVariable("buyer") int buyer){
        return orderService.consumption(buyer);
    }

    @RequestMapping(value = "state/{buyer}/{state}",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<Order> orderState(@PathVariable("buyer") int buyer, @PathVariable("state") int state){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return orderRepository.findByBuyerAndState(buyer,state,sort);
    }

    /**
     * 获取用户订单演出的类型分布
     * @param buyer
     * @return
     */
    @RequestMapping(value = "type/{buyer}",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public int[] type(@PathVariable("buyer") int buyer){
        return orderService.type(buyer);
    }

    /**
     * 获取用户订单总数
     * @return
     */
    @RequestMapping(value = "orderNumber/{buyer}",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public int orderNumber(@PathVariable("buyer") int buyer){
        List<Order> list = orderRepository.findByBuyer(buyer,new Sort(Sort.Direction.DESC, "id"));
        return list.size();
    }
    @RequestMapping(value = "orderType/{buyer}",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public int[] orderType(@PathVariable("buyer") int buyer){
        return orderService.orderType(buyer);
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
