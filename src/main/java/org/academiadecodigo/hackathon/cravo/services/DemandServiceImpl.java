package org.academiadecodigo.hackathon.cravo.services;

import org.academiadecodigo.hackathon.cravo.model.transactions.Demand;

import javax.persistence.EntityManagerFactory;

public class DemandServiceImpl extends AbstractService<Demand>{

    public DemandServiceImpl(EntityManagerFactory emf) {
        super(emf, Demand.class);
    }


}
