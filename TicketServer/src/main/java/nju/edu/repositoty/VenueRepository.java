package nju.edu.repositoty;

import nju.edu.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by xiaoJun on 2018/3/8.
 */
public interface VenueRepository extends JpaRepository<Venue,Integer>{
    List<Venue> findByIdentificationAndPassword(String identification, String password);

    Venue findOne(int venue_id);

    List<Venue> findByState(int state);
}
