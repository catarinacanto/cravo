package org.academiadecodigo.hackathon.cravo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.academiadecodigo.hackathon.cravo.views.Navigation;

public class LoginController {

    @FXML
    void onSubmit(ActionEvent event) {
        Navigation.getInstance().load("help");
    }

}
