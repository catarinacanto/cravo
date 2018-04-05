package org.academiadecodigo.hackathon.cravo.model.item;

import org.academiadecodigo.hackathon.cravo.model.transactions.Demand;
import org.academiadecodigo.hackathon.cravo.model.transactions.Offer;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private ItemType itemType;

    public Item() {
    }

    @OneToMany(
            // propagate changes on customer entity to account entities
            cascade = {CascadeType.ALL},

            // user customer foreign key on account table to establish
            // the many-to-one relationship instead of a join table
            mappedBy = "item_id",

            // fetch accounts from database together with user
            fetch = FetchType.LAZY
    )
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Offer> offers = new ArrayList<>();

    @OneToMany(
            // propagate changes on customer entity to account entities
            cascade = {CascadeType.ALL},

            // user customer foreign key on account table to establish
            // the many-to-one relationship instead of a join table
            mappedBy = "item_id",

            // fetch accounts from database together with user
            fetch = FetchType.LAZY
    )
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Demand> demands = new ArrayList<>();

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public List<Demand> getDemands() {
        return demands;
    }

    public void setDemands(List<Demand> demands) {
        this.demands = demands;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }
}
