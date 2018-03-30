package nju.edu.repositoty;

import nju.edu.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xiaoJun on 2018/3/30.
 */
public interface SeatRepository extends JpaRepository<Seat, Integer>{
    Seat findOne(int seat_id);
}
