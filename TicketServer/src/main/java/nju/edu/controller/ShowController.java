package nju.edu.controller;

import nju.edu.model.Show;
import nju.edu.service.ShowService;
import nju.edu.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by xiaoJun on 2018/3/8.
 */
@RestController
@RequestMapping(value = "/Show")
public class ShowController{

    @Autowired
    private ShowService showService;

    /**
     * 热门演出
     * @return
     */
    @RequestMapping(value = "/hot",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String hot(){
        ArrayList<Show> hots = showService.hot();
        return JSONResult.fillResultString(0,"", hots);
    }
}
