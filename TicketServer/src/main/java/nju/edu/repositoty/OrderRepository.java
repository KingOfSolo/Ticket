package nju.edu.repositoty;

import nju.edu.model.Order;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xiaoJun on 2018/3/26.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>{
    List<Order> findByBuyer(int buyer, Sort sort);

    List<Order> findByShow(int show);

    List<Order> findByBuyerAndState(int buyer, int state, Sort sort);

    List<Order> findByNumber(Long number);

    List<Order> findByState(int state, Sort sort);
}
