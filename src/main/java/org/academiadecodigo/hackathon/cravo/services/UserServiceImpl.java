package org.academiadecodigo.hackathon.cravo.services;

import org.academiadecodigo.hackathon.cravo.controllers.LoginController;
import org.academiadecodigo.hackathon.cravo.model.user.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl extends AbstractService<User> {

    private LoginController loginController;


    public UserServiceImpl(EntityManagerFactory emf) {
        super(emf, User.class);
    }


    public boolean authenticate(String username, String password) {

        EntityManager em = emf.createEntityManager();

        return password.equals(em.find(User.class, username).getPassword());
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }
}
