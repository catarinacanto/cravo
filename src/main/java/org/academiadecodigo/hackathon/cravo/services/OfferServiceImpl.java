package org.academiadecodigo.hackathon.cravo.services;

import org.academiadecodigo.hackathon.cravo.controllers.HelpController;
import org.academiadecodigo.hackathon.cravo.model.transactions.Offer;

import javax.persistence.EntityManagerFactory;

public class OfferServiceImpl extends AbstractService<Offer> {

    private HelpController helpController;

    public OfferServiceImpl(EntityManagerFactory emf) {
        super(emf, Offer.class);
    }

    public void setHelpController(HelpController helpController) {
        this.helpController = helpController;
    }
}
