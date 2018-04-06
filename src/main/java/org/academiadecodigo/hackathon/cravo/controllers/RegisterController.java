package org.academiadecodigo.hackathon.cravo.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import org.academiadecodigo.hackathon.cravo.services.UserRegisterServiceImpl;
import org.academiadecodigo.hackathon.cravo.views.Navigation;

public class RegisterController {

    private UserRegisterServiceImpl userRegisterService;


    @FXML
    private TextField userField;

    @FXML
    private PasswordField passField;

    @FXML
    private TextField emailField;

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
       // System.out.println(userField.getText());
       // System.out.println(passField.getText());
       // System.out.println(emailField.getText());

        String username = userField.getText();

        System.out.println(this);
        userRegisterService.userExists("sbdhsbdj");



        text.setText("Register Successful!! Click here to Login");

        Navigation.getInstance().load("login");
    }



    public void setUserRegisterService(UserRegisterServiceImpl userRegisterService) {
        this.userRegisterService = userRegisterService;
    }

    public TextField getUserField() {
        return userField;
    }

    public PasswordField getPassField() {
        return passField;
    }

    public TextField getEmalField() {
        return emailField;
    }
}


