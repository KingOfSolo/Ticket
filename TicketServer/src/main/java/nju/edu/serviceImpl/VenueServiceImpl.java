package nju.edu.serviceImpl;

import nju.edu.model.Order;
import nju.edu.model.Seat;
import nju.edu.model.Show;
import nju.edu.model.Venue;
import nju.edu.repositoty.OrderRepository;
import nju.edu.repositoty.ShowRepository;
import nju.edu.repositoty.VenueRepository;
import nju.edu.service.VenueService;
import nju.edu.util.OrderState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoJun on 2018/3/16.
 */
@Service
@Transactional
public class VenueServiceImpl implements VenueService{

    @Autowired
    private VenueRepository venueRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Venue register(Venue venue) {
        Venue venue1 = new Venue(recognitionCode(), venue.getEmail(), venue.getPassword(),
                venue.getName(), venue.getAddress(), 0);
        for (Seat seat: venue.getSeats()){
            venue1.addSeat(new Seat(seat.getSeat_name(), seat.getNumber()));
        }
        return venueRepository.save(venue1);
    }

    @Override
    public String login(String identification, String password) {
        if (venueRepository.findByIdentificationAndPassword(identification,password).isEmpty()){
            return null;
        }
        Venue venue = venueRepository.findByIdentificationAndPassword(identification,password).get(0);
        if (venue.getState() == 0){
            return null;
        }
        return String.valueOf(venue.getVenue_id());
    }

    @Override
    public int income(int venue) {
        int total = 0;
        List<Show> showList = showRepository.findByVenue(venue);
        for(Show show: showList){
            List<Order> orderList = orderRepository.findByShow(show.getShow_id());
            for(Order order: orderList){
                if (order.getState() == OrderState.Success){
                    total += (order.getTotal() - order.getDiscount())/2;
                }else if(order.getState() == OrderState.Refund){
                    total += (order.getTotal() - order.getDiscount())/4;
                }
            }
        }
        return total;
    }

    @Override
    public int[] type(int venue) {
        int[] result = new int[9];
        List<Show> showList = showRepository.findByVenue(venue);
        for(Show show: showList){
            List<Order> orderList = orderRepository.findByShow(show.getShow_id());
            for(Order order: orderList){
                if (order.getState() == OrderState.Success){
                    result[show.getType()] += (order.getTotal() - order.getDiscount())/2;
                }else if(order.getState() == OrderState.Refund){
                    result[show.getType()] += (order.getTotal() - order.getDiscount())/4;
                }
            }
        }
        return result;
    }

    @Override
    public int orderNumber(int venue) {
        int num = 0;
        List<Show> showList = showRepository.findByVenue(venue);
        for(Show show: showList){
            List<Order> orderList = orderRepository.findByShow(show.getShow_id());
            num += orderList.size();
        }
        return num;
    }

    @Override
    public int[] orderType(int venue) {
        int[] type = new int[6];
        List<Show> showList = showRepository.findByVenue(venue);
        for(Show show: showList){
            List<Order> orderList = orderRepository.findByShow(show.getShow_id());
            for(Order order: orderList){
                type[order.getState()] += 1;
            }
        }
        return type;
    }

    @Override
    public int planNumber(int venue) {
        List<Show> showList = showRepository.findByVenue(venue);
        return showList.size();
    }

    @Override
    public int[] planType(int venue) {
        int[] result = new int[9];
        List<Show> showList = showRepository.findByVenue(venue);
        for (Show show: showList){
            result[show.getType()] += 1;
        }
        return result;
    }

    @Override
    public Map<Date, Integer> orderNumberPerDay(int venue) {
        Map<Date,Integer> map = new HashMap<>();
        List<Show> showList = showRepository.findByVenue(venue);
        for (Show show: showList){

        }
        return null;
    }

    private String recognitionCode(){
        List<Venue> venues = venueRepository.findAll();
        if (venues.size() == 0){
            return "V000001";
        }else{
            Venue venue = venues.get(venues.size() - 1);
            int id = venue.getVenue_id()+1;
            if (1 <= id && id < 10){
                return "V00000"+id;
            }else if(10 <= id && id < 100){
                return "V0000"+id;
            }else if(100 <= id && id <1000){
                return "V000"+id;
            }else if(1000 <= id && id < 10000){
                return "V00"+id;
            }else if(10000 <= id  && id < 100000){
                return "V0"+id;
            }else{
                return "V"+id;
            }
        }
    }

}
