package nju.edu.repositoty;

import nju.edu.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xiaoJun on 2018/4/3.
 */
@Repository
public interface ManageRepository extends JpaRepository<Manager,Integer>{
    List<Manager> findByAccountAndPassword(String account,String password);
}
