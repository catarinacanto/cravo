package org.academiadecodigo.hackathon.cravo.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.academiadecodigo.hackathon.cravo.views.Navigation;

public class MainController {

    private LoginController loginController;

    @FXML
    void onLoginKey(ActionEvent event) {
        Navigation.getInstance().load("login");
    }

    @FXML
    void onRegister(ActionEvent event) {
        Navigation.getInstance().load("register");
    }

}

