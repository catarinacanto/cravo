package org.academiadecodigo.hackathon.cravo.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.SplitMenuButton;
import org.academiadecodigo.hackathon.cravo.views.Navigation;

public class SelectController {

    @FXML
    private SplitMenuButton food;

    @FXML
    private SplitMenuButton medicine;

    @FXML
    private SplitMenuButton money;

    @FXML
    void onSubmit(ActionEvent event) {
        Navigation.getInstance().load("help");
    }


    @FXML
    void setFood(ActionEvent event) {
        food.setText("batata");
    }

    @FXML
    void setMedicine(ActionEvent event) {
        medicine.setText("Ben-u-ron");
    }

    @FXML
    void setMenuItem(ActionEvent event) {
        money.setText("100");
    }


}

