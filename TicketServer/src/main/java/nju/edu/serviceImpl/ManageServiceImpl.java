package nju.edu.serviceImpl;

import nju.edu.model.Modify;
import nju.edu.model.Venue;
import nju.edu.repositoty.ModifyRepository;
import nju.edu.repositoty.VenueRepository;
import nju.edu.service.MailService;
import nju.edu.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by xiaoJun on 2018/3/17.
 */
@Service
@Transactional
public class ManageServiceImpl implements ManageService{

    @Autowired
    private MailService mailService;

    @Autowired
    private VenueRepository venueRepository;

    @Autowired
    private ModifyRepository modifyRepository;

    @Override
    public void sendEmail(int venueId) {
//        String content = "<h1>来自票务网站的激活邮件，激活请点击以下链接：</h1> <h3> " +
//                " <a href='http://localhost:8075/TicketServer/Manage/active?venueId="+venueId+"'>" +
//                " http://localhost:8075/TicketServer/Manage/active?venueId=" +venueId+" </a></h3>";
        Venue venue = venueRepository.findOne(venueId);
        venue.setState(1);
        String content = "<h1>您申请的场馆已审核通过，识别码为："+venue.getIdentification()+"</h1>";

        mailService.SendHtmlMail(venue.getEmail(), "场馆激活邮件",content);
    }

    @Override
    public String active(int venueId) {
        Venue venue = venueRepository.findOne(venueId);
        venue.setState(1);
        venueRepository.save(venue);
        return "激活成功";
    }

    @Override
    public void notPass(int venueId) {
        Venue venue = venueRepository.findOne(venueId);
        venue.setState(2);
        String content = "<h1>您申请的场馆审核未通过，请修改信息后重新申请</h1>";
        mailService.SendHtmlMail(venue.getEmail(), "场馆信息未通过",content);
    }

    @Override
    public void modifySuccess(int venueId) {
        Venue venue = venueRepository.findOne(venueId);
        Modify modify = modifyRepository.findOne(venueId);
        venue.setName(modify.getName());
        venue.setAddress(modify.getAddress());
        modify.setState(1);
        venueRepository.save(venue);
        modifyRepository.save(modify);
        String content = "<h1>您修改的场馆信息已经审核通过!</h1>";
        mailService.SendHtmlMail(venue.getEmail(), "场馆信息修改成功",content);
    }

    @Override
    public void modifyFail(int venueId) {
        Venue venue = venueRepository.findOne(venueId);
        Modify modify = modifyRepository.findOne(venueId);
        modify.setState(2);
        modifyRepository.save(modify);
        String content = "<h1>您修改的场馆信息审核未通过，请重新修改信息后申请</h1>";
        mailService.SendHtmlMail(venue.getEmail(), "场馆信息审核未通过",content);
    }
}
