package org.academiadecodigo.hackathon.cravo.services;

import org.academiadecodigo.hackathon.cravo.model.item.Item;

import javax.persistence.EntityManagerFactory;

public class ItemServiceImpl extends AbstractService<Item> {


    public ItemServiceImpl(EntityManagerFactory emf) {
        super(emf, Item.class);
    }


}
