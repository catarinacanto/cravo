package org.academiadecodigo.hackathon.cravo.controllers;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class CurrentItemsController {

    @FXML
    void initialize(){
        optText1.setVisible(false);
        optText2.setVisible(false);
        optText3.setVisible(false);
        optText4.setVisible(false);

    }

    @FXML
    private Text optText2;

    @FXML
    private Text optText1;

    @FXML
    private Text optText3;

    @FXML
    private Text optText4;

}