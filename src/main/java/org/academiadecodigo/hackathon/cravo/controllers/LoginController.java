package org.academiadecodigo.hackathon.cravo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.academiadecodigo.hackathon.cravo.services.UserServiceImpl;
import org.academiadecodigo.hackathon.cravo.views.Navigation;
import org.academiadecodigo.hackathon.cravo.services.ServiceRegistry;

public class LoginController implements Controller {

    private UserServiceImpl userService;


    public void initialize(){

        userService = (UserServiceImpl) ServiceRegistry.getInstance().getService("userService");

    }


    @FXML
    private TextField userField;

    @FXML
    private PasswordField passField;

    @FXML
    void onSubmit(ActionEvent event) {
        Navigation.getInstance().load("help");

    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }


}