package org.academiadecodigo.hackathon.cravo.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.academiadecodigo.hackathon.cravo.views.Navigation;

public class MainController implements Controller {

    private LoginController loginController;

    @FXML
    void onLogin(ActionEvent event) {
        Navigation.getInstance().load("login");
    }

    @FXML
    void onRegister(ActionEvent event) {
        Navigation.getInstance().load("register");
    }

}

