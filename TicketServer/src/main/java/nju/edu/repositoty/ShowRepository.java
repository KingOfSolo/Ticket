package nju.edu.repositoty;

import nju.edu.model.Show;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xiaoJun on 2018/3/8.
 */
@Repository
public interface ShowRepository extends JpaRepository<Show,Integer>{
    List<Show> findByType(int type);

    List<Show> findAll();

    Show findOne(int show_id);

    List<Show> findByVenue(int venue);

//    List<Show> findByShow_id(int show_id);

//    List<Show> findByEndtime(String end_time);

}
