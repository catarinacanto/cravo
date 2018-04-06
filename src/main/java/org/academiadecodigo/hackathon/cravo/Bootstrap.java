package org.academiadecodigo.hackathon.cravo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.academiadecodigo.hackathon.cravo.controllers.HelpController;
import org.academiadecodigo.hackathon.cravo.controllers.LoginController;
import org.academiadecodigo.hackathon.cravo.controllers.RegisterController;
import org.academiadecodigo.hackathon.cravo.model.user.User;
import org.academiadecodigo.hackathon.cravo.services.OfferServiceImpl;
import org.academiadecodigo.hackathon.cravo.services.UserRegisterServiceImpl;
import org.academiadecodigo.hackathon.cravo.services.UserServiceImpl;
import org.academiadecodigo.hackathon.cravo.views.Navigation;
import org.academiadecodigo.hackathon.cravo.views.ServiceRegistry;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Bootstrap {

    public void init() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cravo");

        OfferServiceImpl offerService = new OfferServiceImpl(emf);

        UserServiceImpl userService = new UserServiceImpl(emf);

        UserRegisterServiceImpl userRegisterService = new UserRegisterServiceImpl(emf);


        ServiceRegistry.addService("offerService",offerService);
        ServiceRegistry.addService("userService",userService);
        ServiceRegistry.addService("userRegistryService",userRegisterService);

        /*userRegisterService.setRegisterController(registerController);
        System.out.println("-------------------------------------------------\n\n\n\n\n\n\n\n"+contro);
        registerController.setUserRegisterService(userRegisterService);*/

        User user = new User();
        user.setId(1);

       // userRegisterService.userExists(user);


    }
}
