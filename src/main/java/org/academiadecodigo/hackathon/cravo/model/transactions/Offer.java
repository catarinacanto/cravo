package org.academiadecodigo.hackathon.cravo.model.transactions;

import org.academiadecodigo.hackathon.cravo.model.AbstractModel;
import org.academiadecodigo.hackathon.cravo.model.item.Item;
import org.academiadecodigo.hackathon.cravo.model.user.User;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "offer")
public class Offer extends AbstractModel {

    public Offer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User user_id;

    @ManyToOne
    private Item item_id;

    private Integer ammount;

    private Date date;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Item getItem_id() {
        return item_id;
    }

    public void setItem_id(Item item_id) {
        this.item_id = item_id;
    }

    public Integer getAmmount() {
        return ammount;
    }

    public void setAmmount(Integer ammount) {
        this.ammount = ammount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
