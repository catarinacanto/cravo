package org.academiadecodigo.hackathon.cravo.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import org.academiadecodigo.hackathon.cravo.views.Navigation;

public class RegisterController implements Controller {

    @FXML
    private MenuButton checkBoxText;

    @FXML
    private Text text;

    @FXML
    void backToLogin(MouseEvent event) {
        Navigation.getInstance().load("login");
    }

    @FXML
    void chooseOng(ActionEvent event) {
        checkBoxText.setText("ONG");
    }

    @FXML
    void chooseSingle(ActionEvent event) {
        checkBoxText.setText("Single");
    }


    @FXML
    void onSubmit(ActionEvent event) {
        text.setText("Register Successful!! Click here to Login");
    }

}


