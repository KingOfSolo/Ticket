package nju.edu.controller;

import nju.edu.model.*;
import nju.edu.repositoty.*;
import nju.edu.service.MailService;
import nju.edu.service.ManageService;
import nju.edu.service.VenueService;
import nju.edu.util.OrderState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by xiaoJun on 2018/3/17.
 */
@RestController
@RequestMapping("/Manage")
public class ManageController {

    @Autowired
    private VenueRepository venueRepository;

    @Autowired
    private ManageService manageService;

    @Autowired
    private ManageRepository manageRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private VenueService venueService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModifyRepository modifyRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Manager login(@RequestBody Manager manager){
        List<Manager> list = manageRepository.findByAccountAndPassword(manager.getAccount(),manager.getPassword());
        if (list.size() == 0){
            return null;
        }
        return list.get(0);
    }

    /**
     * 获取审核场馆信息列表
     * @return
     */
    @RequestMapping(value = "/checkList", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<Venue> getCheckList(){
        return venueRepository.findByState(0);
    }

    /**
     * 审核通过发送激活邮件
     */
    @RequestMapping(value = "/email/{venueId}",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public void pass(@PathVariable("venueId") int venueId){
        manageService.sendEmail(venueId);
    }

    @RequestMapping(value = "/notPass/{venueId}",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public void notPass(@PathVariable("venueId") int venueId){
        manageService.notPass(venueId);
    }

    @RequestMapping(value = "/active",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String active(HttpServletRequest request){
        String venueId = request.getParameter("venueId");
        System.out.println(venueId);
        return manageService.active(Integer.parseInt(venueId));
    }

    /**
     * 获取修改信息的场馆列表
     * @return
     */
    @RequestMapping(value = "/modifyList",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public List<Modify> modifyList(){
        return modifyRepository.findByState(0);
    }

    @RequestMapping(value = "modifySuccess/{venueId}",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public void modifySuccess(@PathVariable("venueId") int venueId){
        manageService.modifySuccess(venueId);
    }

    @RequestMapping(value = "modifyFail/{venueId}",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public void modifyFail(@PathVariable("venueId") int venueId){
        manageService.modifyFail(venueId);
    }

    @RequestMapping(value = "/payList",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public List<Venue> payList(){
        List<Venue> list = venueRepository.findAll();
        return list;
    }

    @RequestMapping(value = "/payment/{venueId}",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public int payment(@PathVariable("venueId") int venueId){
        return venueService.income(venueId);
    }

    /**
     * 场馆总数
     * @return
     */
    @RequestMapping(value = "/venueNumber",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public int venueNumber(){
        List<Venue> venues = venueRepository.findByState(1);
        return venues.size();
    }

    /**
     * 演出总数
     * @return
     */
    @RequestMapping(value = "/showNumber",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public int showNumber(){
        List<Show> shows = showRepository.findAll();
        return shows.size();
    }

    /**
     * 获取全部演出类型分布
     * @return
     */
    @RequestMapping(value = "/showType",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public int[] showType(){
        int[] result = new int[9];
        List<Show> shows = showRepository.findAll();
        for(Show show: shows){
            result[show.getType()] += 1;
        }
        return result;
    }

    /**
     * 获取总用户数
     * @return
     */
    @RequestMapping(value = "/userNumber",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public int userNumber(){
        List<User> users = userRepository.findByState(1);
        return users.size();
    }

    /**
     * 总收入
     * @return
     */
    @RequestMapping(value = "/income",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public int income(){
        int total = 0;
        List<Order> orders = orderRepository.findAll();
        for(Order order: orders){
            if (order.getState() == OrderState.Success){
                total += (order.getTotal() - order.getDiscount());
            }else if(order.getState() == OrderState.Refund){
                total += (order.getTotal() - order.getDiscount())/2;
            }
        }
        return total;
    }

    /**
     * 收入类型分布
     * @return
     */
    @RequestMapping(value = "/incomeType",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public int[] incomeType(){
        int[] result = new int[9];
        List<Show> shows = showRepository.findAll();
        for(Show show: shows){
            List<Order> orders = orderRepository.findByShow(show.getShow_id());
            for(Order order: orders){
                if (order.getState() == OrderState.Success){
                    result[show.getType()] += (order.getTotal() - order.getDiscount());
                }else if(order.getState() == OrderState.Refund){
                    result[show.getType()] += (order.getTotal() - order.getDiscount())/2;
                }
            }
        }
        return result;
    }
}
