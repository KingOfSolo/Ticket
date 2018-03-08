package nju.edu.controller;

import nju.edu.model.Show;
import nju.edu.model.ShowPrice;
import nju.edu.repositoty.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaoJun on 2018/3/8.
 */
@RestController
@RequestMapping(value = "/Venue")
public class VenueController{
    @Autowired
    private ShowRepository showRepository;

    @RequestMapping(value = "/register",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public String register(){
        return null;
    }

    /**
     * 发布演出
     */
    @RequestMapping(value = "/releaseShow",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public void releaseShow(){
        Show show = new Show(2, "地表最强", "周杰伦地表最强演唱会", "2018-3-8 19:00",
                "2018-3-8 22:00","上海梅赛德斯奔驰文化中心", 0, "666");
        ShowPrice showPrice1 = new ShowPrice("看台一",888);
        ShowPrice showPrice2 = new ShowPrice("看台二",999);
        ShowPrice showPrice3 = new ShowPrice("看台三",1010);
        show.addShowPrice(showPrice1);
        show.addShowPrice(showPrice2);
        show.addShowPrice(showPrice3);
        showRepository.save(show);
    }

}