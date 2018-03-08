package nju.edu.repositoty;

import nju.edu.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by LENOVO on 2018/3/8.
 */
@Repository
public interface ShowRepository extends JpaRepository<Show,Integer>{
    List<Show> findByType(int type);
}
