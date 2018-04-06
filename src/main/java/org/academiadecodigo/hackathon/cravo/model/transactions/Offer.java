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
    private User user;

    @ManyToOne
    private Item item;

    private Integer amount;

    private Date date;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User userd) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", user=" + user +
                ", item=" + item +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
