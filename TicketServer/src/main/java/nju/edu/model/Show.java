package nju.edu.model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by LENOVO on 2018/3/8.
 */
@Entity
@Table(name = "`show`")
public class Show implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "show_id")
    private int show_id;
    @Column(name = "venue_id")
    private int venue_id;
    @Column(name = "name")
    private String name;
    @Column(name = "introduce")
    private String introduce;
    @Column(name = "start_time")
    private String start_time;
    @Column(name = "end_time")
    private String end_time;
    @Column(name = "address")
    private String address;
    @Column(name = "type")
    private int type;
    @Column(name = "poster")
    private String poster;
    @OneToMany(mappedBy="show")
    private Set<ShowPrice> showPrices = new HashSet<ShowPrice>();

    public int getShow_id() {
        return show_id;
    }

    public void setShow_id(int show_id) {
        this.show_id = show_id;
    }

    public int getVenue_id() {
        return venue_id;
    }

    public void setVenue_id(int venue_id) {
        this.venue_id = venue_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Set<ShowPrice> getShowPrices() {
        return showPrices;
    }

    public void setShowPrices(Set<ShowPrice> showPrices) {
        this.showPrices = showPrices;
    }

    public Show(int venue_id, String name, String introduce, String start_time, String end_time, String address, int type, String poster) {
        this.venue_id = venue_id;
        this.name = name;
        this.introduce = introduce;
        this.start_time = start_time;
        this.end_time = end_time;
        this.address = address;
        this.type = type;
        this.poster = poster;
    }

    public Show(){}

    public void addShowPrice(ShowPrice showPrice){
        this.showPrices.add(showPrice);
        showPrice.setShow(this);
    }
}
