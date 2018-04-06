package org.academiadecodigo.hackathon.cravo.services;

import org.academiadecodigo.hackathon.cravo.controllers.RegisterController;
import org.academiadecodigo.hackathon.cravo.model.user.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class UserRegisterServiceImpl extends AbstractService<User> {

    private RegisterController registerController;

    public UserRegisterServiceImpl(EntityManagerFactory emf) {
        super(emf, User.class);
    }

    public boolean userExists(String username){

        EntityManager em = emf.createEntityManager();

        User user = em.find(User.class, username);

        if(user != null) {
            return false;
        }

        return true;


    }


    public void setRegisterController(RegisterController registerController) {
        this.registerController = registerController;
    }


}
