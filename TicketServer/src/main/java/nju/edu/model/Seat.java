package nju.edu.model;

import javax.persistence.*;

/**
 * Created by xiaoJun on 2018/3/8.
 */
@Entity
@Table(name = "seat")
public class Seat {
    @Id
    @GeneratedValue
    @Column(name = "seat_id")
    private int seat_id;
    @Column(name = "seat_name")
    private String seat_name;
    @Column(name = "number")
    private int number;
    @ManyToOne(cascade=CascadeType.ALL,optional=false)
    @JoinColumn(name="venue_id")
    private Venue venue;

    public int getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }

    public String getSeat_name() {
        return seat_name;
    }

    public void setSeat_name(String seat_name) {
        this.seat_name = seat_name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Seat(String seat_name, int number) {
        this.seat_name = seat_name;
        this.number = number;
    }
}
