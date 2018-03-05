package nju.edu.service;

/**
 * Created by xiaoJun on 2018/3/5.
 */
public interface MailService {

    void SendHtmlMail(String to, String object, String content);
}
