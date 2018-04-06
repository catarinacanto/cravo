package org.academiadecodigo.hackathon.cravo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.academiadecodigo.hackathon.cravo.views.Navigation;

public class FinalController {

    @FXML
    private Button itemsButton;

    @FXML
    void goToItems(ActionEvent event) {
        Navigation.getInstance().load("currentitems");
    }
}
