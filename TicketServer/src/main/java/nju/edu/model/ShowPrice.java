package nju.edu.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by LENOVO on 2018/3/8.
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
    @ManyToOne(optional=false)
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

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public ShowPrice(String seat_name, int price) {
        this.seat_name = seat_name;
        this.price = price;
    }
}
