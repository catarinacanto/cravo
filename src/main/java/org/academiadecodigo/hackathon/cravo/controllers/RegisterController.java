package org.academiadecodigo.hackathon.cravo.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import org.academiadecodigo.hackathon.cravo.interwebs.SendEmail;
import org.academiadecodigo.hackathon.cravo.model.user.User;
import org.academiadecodigo.hackathon.cravo.services.UserRegisterServiceImpl;
import org.academiadecodigo.hackathon.cravo.services.UserServiceImpl;
import org.academiadecodigo.hackathon.cravo.views.Navigation;
import org.academiadecodigo.hackathon.cravo.services.ServiceRegistry;

import java.util.List;

public class RegisterController implements Controller {

    private UserRegisterServiceImpl userRegisterService;
    private SendEmail mailer;

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
    void initialize() {
        mailer = new SendEmail((UserServiceImpl) ServiceRegistry.getInstance().getService("userServiceImpl"));
    }

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
        UserRegisterServiceImpl userRegisterService =
                (UserRegisterServiceImpl) ServiceRegistry.getInstance().getService("userRegistryService");

        if (!userRegisterService.userExists(username)) {

            User user = new User(userField.getText(), passField.getText(), emailField.getText());

            userRegisterService.registerUser(user);

            List<User> userList = userRegisterService.list();
            Integer registerId = null;

            mailer.register(emailField.getText(), userField.getText());

            text.setText("Register Successful!! Click here to Login");
        }

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


