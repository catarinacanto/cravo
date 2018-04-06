package org.academiadecodigo.hackathon.cravo.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import org.academiadecodigo.hackathon.cravo.views.Navigation;

public class HelpController {

    @FXML
    private Text offerText;

    @FXML
    void need(ActionEvent event) {
        Navigation.getInstance().load("select");
    }

    @FXML
    void offer(ActionEvent event) {
        Navigation.getInstance().load("select");
    }
}
