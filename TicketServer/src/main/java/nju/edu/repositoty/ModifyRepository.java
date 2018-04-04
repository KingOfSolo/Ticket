package nju.edu.repositoty;

import nju.edu.model.Modify;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by xiaoJun on 2018/4/4.
 */
public interface ModifyRepository extends JpaRepository<Modify,Integer>{
    List<Modify> findByState(int state);

}
