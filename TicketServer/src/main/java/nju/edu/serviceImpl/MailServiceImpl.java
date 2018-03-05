package nju.edu.serviceImpl;

import nju.edu.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.util.Properties;

/**
 * Created by LENOVO on 2018/3/5.
 */
@Service
@Transactional
public class MailServiceImpl implements MailService{

    private final JavaMailSender mailSender;

//    private JavaMailSenderImpl mailSender;

    @Value("${mail.fromMail.addr}")
    private String from;

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    public MailServiceImpl(JavaMailSender sender) {
        this.mailSender = sender;
    }

    @Override
    public void SendHtmlMail(String to, String subject, String content) {
//        mailSender = new JavaMailSenderImpl();
//        mailSender.setHost(host);
//        mailSender.setUsername(username);
//        mailSender.setPassword(password);
//        mailSender.setDefaultEncoding("UTF-8");
//
//        Properties prop = new Properties();
//        prop.put("mail.smtp.auth", "true");
//        prop.put("mail.smtp.ssl.enable", "true");
//        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        mailSender.setJavaMailProperties(prop);
//
//        Session session = Session.getDefaultInstance(prop, new Authenticator(){
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, password);
//            }});
//
//        MimeMessage mailMessage = mailSender.createMimeMessage();
//        MimeMessageHelper message = new MimeMessageHelper(mailMessage);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        try {

            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
