package nju.edu.controller;

import nju.edu.model.Seat;
import nju.edu.model.Show;
import nju.edu.model.ShowPrice;
import nju.edu.model.Venue;
import nju.edu.repositoty.ShowRepository;
import nju.edu.repositoty.VenueRepository;
import nju.edu.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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

    @Value("${prop.upload-folder}")
    private String UPLOAD_FOLDER;

    @RequestMapping(value = "/register",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public Venue register(@RequestBody Venue venue){
        System.out.print("here   ----------------");
        Venue venue1 = new Venue("3855202", venue.getEmail(), venue.getPassword(),
                venue.getName(), venue.getAddress(), 0);
        for (Seat seat: venue.getSeats()){
            venue1.addSeat(new Seat(seat.getSeat_name(), seat.getNumber()));

        }
        return venueRepository.save(venue1);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String login(@RequestBody Venue venue){
        String identification = venue.getIdentification();
        String password = venue.getPassword();
        System.out.println(identification + "   " + password);
        return venueService.login(identification, password);
    }

    /**
     * 根据id获取场馆信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/id/{id}",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public Venue getInfo(@PathVariable("id") int id){
        return venueRepository.findOne(id);
    }

    @RequestMapping(value = "/uploadPoster")
    public String upload(MultipartFile file){
        try {
            byte[] bytes = file.getBytes();
            Date date = new Date();
            Path path = Paths.get(UPLOAD_FOLDER + date.getTime()+ file.getOriginalFilename());
            //如果没有files文件夹，则创建
            if (!Files.isWritable(path)) {
                Files.createDirectories(Paths.get(UPLOAD_FOLDER));
            }
            //文件写入指定路径
            Files.write(path, bytes);
            return "localhost:8075/TicketServer/"+date.getTime()+file.getOriginalFilename();
        } catch (IOException e) {
            e.printStackTrace();
            return "文件上传失败";
        }
    }

    /**
     * 发布演出
     */
    @RequestMapping(value = "/releaseShow",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public Show releaseShow(@RequestBody Show show){
        Show show2 = new Show(show.getVenue(),show.getName(),show.getIntroduce(),show.getStart_time(),
                show.getEnd_time(),show.getAddress(),show.getType(),show.getPoster());
        for (ShowPrice showPrice: show.getShowPrices()){
            show2.addShowPrice(showPrice);
        }
        return showRepository.save(show2);
    }

    @RequestMapping(value = "/showList/{venue}",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public List<Show> showList(@PathVariable("venue") int venue){
//        Sort sort = new Sort(Sort.Direction.DESC, "show_id");
        return showRepository.findByVenue(venue);
    }

    /**
     * 获取场馆的总收入
     * @param venue
     * @return
     */
    @RequestMapping(value = "/income/{venue}",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public int income(@PathVariable("venue") int venue){
        return venueService.income(venue);
    }

    /**
     * 获取场馆收入的类型分布
     * @param venue
     * @return
     */
    @RequestMapping(value = "/type/{venue}",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public int[] type(@PathVariable("venue") int venue){
//        Sort sort = new Sort(Sort.Direction.DESC, "show_id");
        return venueService.type(venue);
    }

    /**
     * 获取场馆的总订单数
     */
    @RequestMapping(value = "/orderNumber/{venue}",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public int orderNumber(@PathVariable("venue") int venue){
        return venueService.orderNumber(venue);
    }

    /**
     *获取场馆的订单类型分布
     */
    @RequestMapping(value = "/orderType/{venue}",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public int[] orderType(@PathVariable("venue") int venue){
        return venueService.orderType(venue);
    }

    /**
     * 获取场馆的总计划数
     */
    @RequestMapping(value = "/planNumber/{venue}",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public int planNumber(@PathVariable("venue") int venue){
        return venueService.planNumber(venue);
    }

    /**
     * 获取场馆计划类型分布
     */
    @RequestMapping(value = "/planType/{venue}",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public int[] planType(@PathVariable("venue") int venue){
        return venueService.planType(venue);
    }


}
