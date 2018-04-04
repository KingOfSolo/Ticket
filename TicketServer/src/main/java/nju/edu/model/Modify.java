package nju.edu.model;

import javax.persistence.*;

/**
 * Created by xiaoJun on 2018/4/4.
 */
@Entity
@Table(name = "modify")
public class Modify {
    @Id
    private int venue_id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "state")
    private int state;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Modify(){}
}
