package nju.edu.service;

import nju.edu.model.Order;

/**
 * Created by xiaoJun on 2018/3/31.
 */
public interface OrderService {
    Order confirm(Order order);

    void orderPay(Long number);

    void payFail(Long number);

    int consumption(int buyer);

    int[] type(int buyer);

    int[] orderType(int buyer);

    void refund(Long number);
}
