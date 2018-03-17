package nju.edu.serviceImpl;

import nju.edu.model.Venue;
import nju.edu.repositoty.VenueRepository;
import nju.edu.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by xiaoJun on 2018/3/16.
 */
@Service
@Transactional
public class VenueServiceImpl implements VenueService{

    @Autowired
    private VenueRepository venueRepository;

    @Override
    public Venue login(String identification, String password) {
        if (venueRepository.findByIdentificationAndPassword(identification,password).isEmpty()){
            return null;
        }
        Venue venue = venueRepository.findByIdentificationAndPassword(identification,password).get(0);
        if (venue.getState() == 0){
            return null;
        }
        return venue;
    }
}
