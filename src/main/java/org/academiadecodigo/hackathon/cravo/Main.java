package org.academiadecodigo.hackathon.cravo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cravo");

        EntityManager em = emf.createEntityManager();

    }
}
