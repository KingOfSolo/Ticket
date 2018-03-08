package nju.edu.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaoJun on 2018/3/8.
 */
@Entity
@Table(name = "venue")
public class Venue {
    @Id
    @GeneratedValue
    @Column(name = "venue_id")
    private int venue_id;
    @Column(name = "identification")
    private String identification;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @OneToMany(mappedBy="venue",cascade = javax.persistence.CascadeType.ALL)
    private Set<Seat> seats = new HashSet<>();

    public int getVenue_id() {
        return venue_id;
    }

    public void setVenue_id(int venue_id) {
        this.venue_id = venue_id;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Set<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }

    public Venue(String identification, String email, String password, String name, String address) {
        this.identification = identification;
        this.email = email;
        this.password = password;
        this.name = name;
        this.address = address;
    }

    public void addSeat(Seat seat){
        this.seats.add(seat);
        seat.setVenue(this);
    }
}
