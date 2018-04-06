package org.academiadecodigo.hackathon.cravo.services;

import org.academiadecodigo.hackathon.cravo.controllers.RegisterController;
import org.academiadecodigo.hackathon.cravo.model.user.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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


    public void setRegisterController(RegisterController registerController) {
        this.registerController = registerController;
    }


}
