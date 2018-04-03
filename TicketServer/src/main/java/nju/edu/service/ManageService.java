package nju.edu.service;

/**
 * Created by xiaoJun on 2018/3/17.
 */
public interface ManageService {
    void sendEmail(int venueId);

    String active(int venueId);

    void notPass(int venueId);
}
