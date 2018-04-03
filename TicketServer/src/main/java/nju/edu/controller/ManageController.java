package nju.edu.controller;

import nju.edu.model.Manager;
import nju.edu.model.Venue;
import nju.edu.repositoty.ManageRepository;
import nju.edu.repositoty.VenueRepository;
import nju.edu.service.MailService;
import nju.edu.service.ManageService;
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

    @RequestMapping(value = "/active",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String active(HttpServletRequest request){
        String venueId = request.getParameter("venueId");
        System.out.println(venueId);
        return manageService.active(Integer.parseInt(venueId));
    }
}
