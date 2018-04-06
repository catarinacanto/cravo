package org.academiadecodigo.hackathon.cravo.services;

import org.academiadecodigo.hackathon.cravo.model.transactions.Offer;

import javax.persistence.EntityManagerFactory;

public class OfferDataBaseService extends AbstractService<Offer> {

    public OfferDataBaseService(EntityManagerFactory emf) {
        super(emf, Offer.class);
    }

}
