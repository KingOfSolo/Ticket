package nju.edu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by xiaoJun on 2018/2/28.
 */
@Entity
@Table(name = "user")
public class User implements Serializable{

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private int name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }
}
