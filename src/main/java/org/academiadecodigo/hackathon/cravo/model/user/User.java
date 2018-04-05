package org.academiadecodigo.hackathon.cravo.model.user;


import org.academiadecodigo.hackathon.cravo.model.AbstractModel;
import org.academiadecodigo.hackathon.cravo.model.item.Item;
import org.academiadecodigo.hackathon.cravo.model.transactions.Demand;
import org.academiadecodigo.hackathon.cravo.model.transactions.Offer;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User extends AbstractModel{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String name;
    private String password;
    private String email;
    private String streetAddress;
    private String city;
    private String country;
    private UserType type;

    public User() {
    }

    @OneToMany(
            // propagate changes on customer entity to account entities
            cascade = {CascadeType.ALL},


            // user customer foreign key on account table to establish
            // the many-to-one relationship instead of a join table
            mappedBy = "user_id",

            // fetch accounts from database together with user
            fetch = FetchType.EAGER
    )

    @Fetch(value = FetchMode.SUBSELECT)
    private List<Offer> offers = new ArrayList<>();

    @OneToMany(
            // propagate changes on customer entity to account entities
            cascade = {CascadeType.ALL},

            // user customer foreign key on account table to establish
            // the many-to-one relationship instead of a join table
            mappedBy = "user_id",

            // fetch accounts from database together with user
            fetch = FetchType.EAGER
    )
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Demand> demands = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
}
