package nju.edu.controller;

import nju.edu.model.Seat;
import nju.edu.model.Show;
import nju.edu.model.ShowPrice;
import nju.edu.model.Venue;
import nju.edu.repositoty.ShowRepository;
import nju.edu.repositoty.VenueRepository;
import nju.edu.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;

/**
 * Created by xiaoJun on 2018/3/8.
 */
@RestController
@RequestMapping(value = "/Venue")
public class VenueController{
    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private VenueRepository venueRepository;

    @Autowired
    private VenueService venueService;

    @RequestMapping(value = "/register",method = RequestMethod.POST,produces = "application/json;charset=UTF-8",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Venue register(@RequestBody Venue venue){
        Venue venue1 = new Venue("3855202", venue.getEmail(), venue.getPassword(),
                venue.getName(), venue.getAddress(), 0);
//        System.out.println(venue.getPassword());
        for (Seat seat: venue.getSeats()){
            venue1.addSeat(new Seat(seat.getSeat_name(), seat.getNumber()));

        }
        return venueRepository.save(venue1);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public @ResponseBody Venue login(Venue venue){
//        String identification = request.getParameter("identification");
//        String password = request.getParameter("password");
        String identification = venue.getIdentification();
        String password = venue.getPassword();
        System.out.println(identification + "   " + password);
        return venueService.login(identification, password);
    }

    /**
     * 发布演出
     */
    @RequestMapping(value = "/releaseShow",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public void releaseShow(){
//        Show show = new Show(2, "地表最强", "周杰伦地表最强演唱会", "2018-3-8 19:00",
//                "2018-3-8 22:00","上海梅赛德斯奔驰文化中心", 0, "666");
//        ShowPrice showPrice1 = new ShowPrice("看台一",888);
//        ShowPrice showPrice2 = new ShowPrice("看台二",999);
//        ShowPrice showPrice3 = new ShowPrice("看台三",1010);
//        show.addShowPrice(showPrice1);
//        show.addShowPrice(showPrice2);
//        show.addShowPrice(showPrice3);
//        showRepository.save(show);
    }

}
