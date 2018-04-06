package org.academiadecodigo.hackathon.cravo.services;

import org.academiadecodigo.hackathon.cravo.controllers.RegisterController;
import org.academiadecodigo.hackathon.cravo.model.user.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.List;

public class UserRegisterServiceImpl extends AbstractService<User> {

    private RegisterController registerController;

    public UserRegisterServiceImpl(EntityManagerFactory emf) {
        super(emf, User.class);
    }

    public boolean userExists(String username){

        EntityManager em = emf.createEntityManager();


        List<User> users = list();

        for (User user : users) {
            if (user.getUsername().equals(username)){
                return true;
            }
        }

      return false;


    }

    public void registerUser(User user){

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();

            em.merge(user);

            em.getTransaction().commit();

        } catch (RollbackException ex) {

            em.getTransaction().rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }


    public void setRegisterController(RegisterController registerController) {
        this.registerController = registerController;
    }


}
