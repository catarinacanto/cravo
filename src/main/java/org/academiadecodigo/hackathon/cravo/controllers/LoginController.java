package org.academiadecodigo.hackathon.cravo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.academiadecodigo.hackathon.cravo.services.OfferServiceImpl;
import org.academiadecodigo.hackathon.cravo.services.UserServiceImpl;
import org.academiadecodigo.hackathon.cravo.views.Navigation;
import org.academiadecodigo.hackathon.cravo.views.ServiceRegistry;

public class LoginController {

    private UserServiceImpl userService;


    public void initialize(){

        userService = (UserServiceImpl) ServiceRegistry.getService("userService");
    }

    @FXML
    void onSubmit(ActionEvent event) {
        Navigation.getInstance().load("help");
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }


}