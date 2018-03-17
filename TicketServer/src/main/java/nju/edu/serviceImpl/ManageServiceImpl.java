package nju.edu.serviceImpl;

import nju.edu.model.Venue;
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

    @Override
    public void sendEmail(int venueId) {
        String content = "<h1>来自票务网站的激活邮件，激活请点击以下链接：</h1> <h3> " +
                " <a href='http://localhost:8075/TicketServer/Manage/active?venueId="+venueId+"'>" +
                " http://localhost:8075/TicketServer/Manage/active?venueId=" +venueId+" </a></h3>";
        Venue venue = venueRepository.findOne(venueId);
        mailService.SendHtmlMail(venue.getEmail(), "场馆激活邮件",content);
    }

    @Override
    public String active(int venueId) {
        Venue venue = venueRepository.findOne(venueId);
        venue.setState(1);
        venueRepository.save(venue);
        return "激活成功";
    }
}
