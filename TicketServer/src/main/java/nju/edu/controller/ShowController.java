package nju.edu.controller;

import nju.edu.model.Show;
import nju.edu.repositoty.ShowRepository;
import nju.edu.service.ShowService;
import nju.edu.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoJun on 2018/3/8.
 */
@RestController
@RequestMapping(value = "/Show")
public class ShowController{

    @Autowired
    private ShowService showService;

    @Autowired
    private ShowRepository showRepository;

    /**
     * 热门演出
     * @return
     */
    @RequestMapping(value = "/hot",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String hot(){
        List<Show> hots = showRepository.findAll();
        return JSONResult.fillResultString(0,"", hots);
    }

    /**
     * 根据类型查询演出
     * @param type
     * @return
     */
    @RequestMapping(value = "/type/{type}",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public List<Show> type(@PathVariable("type") int type){
        List<Show> results = new ArrayList<>();
        if (type == 0){
            for (int i = 1; i <= 8; i++){
                List<Show> shows = showRepository.findByType(i);
                for(int j = shows.size() - 1; j >=0; j--){
                    results.add(shows.get(j));
                }
            }
        }else{
            List<Show> shows = showRepository.findByType(type);
            for(int i = shows.size() - 1; i >=0; i--){
                results.add(shows.get(i));
            }
        }
        return results;
    }

    /**
     * 根据id获取演出信息
     * @param id 演出id
     * @return 演出信息
     */
    @RequestMapping(value = "/id/{id}",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public Show getShowInfo(@PathVariable("id") int id){
        return showRepository.findOne(id);
    }
}