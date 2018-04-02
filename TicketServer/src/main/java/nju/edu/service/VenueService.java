package nju.edu.service;

import nju.edu.model.Venue;

import java.util.Date;
import java.util.Map;

/**
 * Created by xiaoJun on 2018/3/16.
 */
public interface VenueService {
    String login(String identification, String password);

    int income(int venue);

    int[] type(int venue);

    int orderNumber(int venue);

    int[] orderType(int venue);

    int planNumber(int venue);

    int[] planType(int venue);

    Map<Date,Integer> orderNumberPerDay(int venue);
}
