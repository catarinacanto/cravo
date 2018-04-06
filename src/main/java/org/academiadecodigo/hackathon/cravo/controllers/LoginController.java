package org.academiadecodigo.hackathon.cravo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.academiadecodigo.hackathon.cravo.model.user.User;
import org.academiadecodigo.hackathon.cravo.services.CurrentUserService;
import org.academiadecodigo.hackathon.cravo.services.UserServiceImpl;
import org.academiadecodigo.hackathon.cravo.views.Navigation;
import org.academiadecodigo.hackathon.cravo.services.ServiceRegistry;

public class LoginController implements Controller {

    private UserServiceImpl userService;

    @FXML
    private Text errorMsg;

    public void initialize() {
        userService = (UserServiceImpl) ServiceRegistry.getInstance().getService("userService");
        errorMsg.setVisible(false);
    }



    @FXML
    private TextField userField;

    @FXML
    private PasswordField passField;

    @FXML
    void onSubmit(ActionEvent event) {
        User logInUser = null;

        if ((logInUser = userService.authenticate(userField.getText(), passField.getText())) != null) {

            ServiceRegistry.getInstance().addService(
                    CurrentUserService.class.getSimpleName(),
                    new CurrentUserService(logInUser));
            System.out.println(CurrentUserService.class.getSimpleName());
            Navigation.getInstance().load("help");

        }

        errorMsg.setVisible(true);

    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }


    public void onReturn(ActionEvent actionEvent) {
        Navigation.getInstance().load("mainMenu");
    }
}