package nju.edu.repositoty;

import nju.edu.model.ShowPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by LENOVO on 2018/3/8.
 */
@Repository
public interface ShowPriceRepository extends JpaRepository<ShowPrice, Integer>{

}
