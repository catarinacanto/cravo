package org.academiadecodigo.hackathon.cravo;

import org.academiadecodigo.hackathon.cravo.model.user.User;
import org.academiadecodigo.hackathon.cravo.services.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Bootstrap {

    public void init() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cravo");

        OfferServiceImpl offerService = new OfferServiceImpl(emf);

        UserServiceImpl userService = new UserServiceImpl(emf);

        UserRegisterServiceImpl userRegisterService = new UserRegisterServiceImpl(emf);
        ItemServiceImpl itemService = new ItemServiceImpl(emf);
        OfferDataBaseService offerDataBaseService = new OfferDataBaseService(emf);
    
        ServiceRegistry.getInstance().addService("offerService",offerService);
        ServiceRegistry.getInstance().addService("userService",userService);
        ServiceRegistry.getInstance().addService("itemService", itemService);
        ServiceRegistry.getInstance().addService("userRegistryService",userRegisterService);
        ServiceRegistry.getInstance().addService("offerDataBaseService",offerDataBaseService);
        
        ServiceRegistry.getInstance().addService("ItemServiceImpl", itemService);

        /*userRegisterService.setRegisterController(registerController);
        System.out.println("-------------------------------------------------\n\n\n\n\n\n\n\n"+contro);
        registerController.setUserRegisterService(userRegisterService);*/

        User user = new User();
        user.setId(1);

       // userRegisterService.userExists(user);


    }
}
