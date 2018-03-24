package nju.edu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by xiaoJun on 2018/3/8.
 */
@Entity
@Table(name = "show_price")
public class ShowPrice implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
//    @Column(name = "show_id")
//    private int show_id;
    @Column(name = "seat_name")
    private String seat_name;
    @Column(name = "price")
    private int price;
    @Column(name = "total_num")
    private int total_num;
    @Column(name = "remain_num")
    private int remain_num;
    @JsonIgnore
    @ManyToOne(optional=false,cascade = CascadeType.ALL)
    @JoinColumn(name="show_id")
    private Show show;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public int getShow_id() {
//        return show_id;
//    }
//
//    public void setShow_id(int show_id) {
//        this.show_id = show_id;
//    }

    public String getSeat_name() {
        return seat_name;
    }

    public void setSeat_name(String seat_name) {
        this.seat_name = seat_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotal_num() {
        return total_num;
    }

    public void setTotal_num(int total_num) {
        this.total_num = total_num;
    }

    public int getRemain_num() {
        return remain_num;
    }

    public void setRemain_num(int remain_num) {
        this.remain_num = remain_num;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public ShowPrice(String seat_name, int price, int total_num, int remain_num) {
        this.seat_name = seat_name;
        this.price = price;
        this.total_num = total_num;
        this.remain_num = remain_num;
    }

    public ShowPrice(){}
}
