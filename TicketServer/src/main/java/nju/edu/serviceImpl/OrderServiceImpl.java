package nju.edu.serviceImpl;

import nju.edu.model.Order;
import nju.edu.model.ShowPrice;
import nju.edu.model.User;
import nju.edu.repositoty.OrderRepository;
import nju.edu.repositoty.ShowPriceRepository;
import nju.edu.repositoty.UserRepository;
import nju.edu.service.OrderService;
import nju.edu.util.Member;
import nju.edu.util.OrderState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by xiaoJun on 2018/3/31.
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShowPriceRepository showPriceRepository;

    @Override
    public Order confirm(Order order) {
        Date date = new Date();
        order.setDate(date);
        order.setNumber(date.getTime());
        order.setState(OrderState.Pay);
        ShowPrice showPrice = showPriceRepository.findOne(order.getSeat());
        showPrice.setRemain_num(showPrice.getRemain_num() - 1);
        showPriceRepository.save(showPrice);
        return orderRepository.save(order);
    }

    @Override
    public void orderPay(Long number) {
        Order order = orderRepository.findByNumber(number).get(0);
        order.setState(OrderState.Success);
        int total = order.getTotal() - order.getDiscount();
        User user = userRepository.findOne(order.getBuyer());
        user.setBalance(user.getBalance() - total);
        int accumulation = user.getAccumulation() + total;
        user.setAccumulation(accumulation);
        user.setLevel(levelCheck(accumulation));
        orderRepository.save(order);
        userRepository.save(user);
    }

    @Override
    public void payFail(Long number) {
        Order order = orderRepository.findByNumber(number).get(0);
        order.setState(OrderState.Fail);
        ShowPrice showPrice = showPriceRepository.findOne(order.getSeat());
        showPrice.setRemain_num(showPrice.getRemain_num() + 1);
    }

    /**
     * 会员等级设置
     * @param accumulation 积分
     * @return 等级
     */
    private int levelCheck(int accumulation){
        if (Member.LEVEL_1 <= accumulation && accumulation < Member.LEVEL_2){
            return 1;
        }else if(Member.LEVEL_2 <= accumulation && accumulation < Member.LEVEL_3){
            return 2;
        }else if(Member.LEVEL_3 <= accumulation && accumulation < Member.LEVEL_4){
            return 3;
        }else if(Member.LEVEL_4 <= accumulation && accumulation < Member.LEVEL_5){
            return 4;
        }else if(Member.LEVEL_5 <= accumulation && accumulation < Member.LEVEL_6){
            return 5;
        }else if(Member.LEVEL_6 <= accumulation && accumulation < Member.LEVEL_7){
            return 6;
        }else if(Member.LEVEL_7 <= accumulation && accumulation < Member.LEVEL_8){
            return 7;
        }else if(Member.LEVEL_8 <= accumulation && accumulation < Member.LEVEL_9){
            return 8;
        }else{
            return 9;
        }
    }
}
