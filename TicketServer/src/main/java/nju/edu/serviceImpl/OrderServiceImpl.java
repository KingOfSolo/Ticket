package nju.edu.serviceImpl;

import nju.edu.model.Order;
import nju.edu.model.Show;
import nju.edu.model.ShowPrice;
import nju.edu.model.User;
import nju.edu.repositoty.OrderRepository;
import nju.edu.repositoty.ShowPriceRepository;
import nju.edu.repositoty.ShowRepository;
import nju.edu.repositoty.UserRepository;
import nju.edu.service.OrderService;
import nju.edu.util.Member;
import nju.edu.util.OrderState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    @Autowired
    private ShowRepository showRepository;

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

    @Override
    public int consumption(int buyer) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        List<Order> list = orderRepository.findByBuyer(buyer,sort);
        int total = 0;
        for(Order order: list){
            if(order.getState() != OrderState.Pay && order.getState() != OrderState.Fail){
                total += (order.getTotal() - order.getDiscount());
            }
        }
        return total;
    }

    @Override
    public int[] type(int buyer) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        List<Order> list = orderRepository.findByBuyer(buyer,sort);
        int[] type = new int[9];
        for(Order order: list){
            if(order.getState() != OrderState.Pay && order.getState() != OrderState.Fail){
                Show show = showRepository.findOne(order.getShow());
                type[show.getType()] += (order.getTotal() - order.getDiscount());
            }
        }
        return type;
    }

    @Override
    public int[] orderType(int buyer) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        List<Order> list = orderRepository.findByBuyer(buyer,sort);
        int[] type = new int[6];
        for(Order order: list){
            type[order.getState()] += 1;
        }
        return type;

    }

    @Override
    public void refund(Long number) {
        Order order = orderRepository.findByNumber(number).get(0);
        order.setState(OrderState.Refund);
        User user = userRepository.findOne(order.getBuyer());
        user.setBalance(user.getBalance() + (int)((order.getTotal() - order.getDiscount())/2));
        ShowPrice showPrice = showPriceRepository.findOne(order.getSeat());
        showPrice.setRemain_num(showPrice.getRemain_num() + 1);
        orderRepository.save(order);
        userRepository.save(user);
        showPriceRepository.save(showPrice);
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
