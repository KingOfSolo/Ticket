package nju.edu.repositoty;

import nju.edu.model.ShowPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xiaoJun on 2018/3/8.
 */
@Repository
public interface ShowPriceRepository extends JpaRepository<ShowPrice, Integer>{
//    @Query(value = "select * from show_price where show_price.show_id = ?1", nativeQuery = true)
//    List<ShowPrice> findByShowId(int show_id);


}
