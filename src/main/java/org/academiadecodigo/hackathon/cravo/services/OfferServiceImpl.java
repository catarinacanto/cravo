package org.academiadecodigo.hackathon.cravo.services;

import org.academiadecodigo.hackathon.cravo.model.transactions.Offer;

import javax.persistence.EntityManagerFactory;

public class OfferServiceImpl extends AbstractService<Offer> {

    public OfferServiceImpl(EntityManagerFactory emf) {
        super(emf, Offer.class);
    }

}
