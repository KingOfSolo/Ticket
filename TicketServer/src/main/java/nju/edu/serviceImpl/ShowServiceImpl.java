package nju.edu.serviceImpl;

import nju.edu.model.Show;
import nju.edu.repositoty.ShowPriceRepository;
import nju.edu.repositoty.ShowRepository;
import nju.edu.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by xiaoJun on 2018/3/9.
 */
@Service
@Transactional
public class ShowServiceImpl implements ShowService{

    @Autowired
    private ShowRepository showRepository;

    @Override
    public ArrayList<Show> hot() {
        ArrayList<Show> hots = new ArrayList<>();
        List<Show> allShow = showRepository.findAll();
        if(allShow.size() <= 10){
            for(int i = allShow.size() - 1; i >= 0; i--){
                hots.add(allShow.get(i));
            }
        }else{
            for(int i = 0; i < 10; i++){
                hots.add(allShow.get(allShow.size() - i));
            }
        }

        return hots;
    }
}
