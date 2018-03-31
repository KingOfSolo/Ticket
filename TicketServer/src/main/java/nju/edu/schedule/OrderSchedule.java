package nju.edu.schedule;

import nju.edu.model.Order;
import nju.edu.model.ShowPrice;
import nju.edu.repositoty.OrderRepository;
import nju.edu.repositoty.ShowPriceRepository;
import nju.edu.util.OrderState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by xiaoJun on 2018/3/31.
 */
@Component
public class OrderSchedule {
    public final static long ONE_MINUTE = 60 * 1000;

    public final static long FIFTEEN_MINUTES = 15 * 60 * 1000;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ShowPriceRepository showPriceRepository;

    /**
     * 每分钟检查订单支付时间是否超过十五分钟，超过则设置订单支付超时
     */
    @Scheduled(fixedRate = ONE_MINUTE)
    public void OrderStateChange(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        List<Order> list = orderRepository.findByState(OrderState.Pay,sort);
        for(Order order: list){
            Date date = new Date();
            if ((order.getDate().getTime() + FIFTEEN_MINUTES) < date.getTime()){
                order.setState(OrderState.Fail);
                ShowPrice showPrice = showPriceRepository.findOne(order.getSeat());
                showPrice.setRemain_num(showPrice.getRemain_num() + 1);
                orderRepository.save(order);
                showPriceRepository.save(showPrice);
            }
        }
    }
}
