package org.academiadecodigo.hackathon.cravo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.academiadecodigo.hackathon.cravo.services.UserServiceImpl;
import org.academiadecodigo.hackathon.cravo.views.Navigation;
import org.academiadecodigo.hackathon.cravo.services.ServiceRegistry;

public class LoginController implements Controller {

    private UserServiceImpl userService;


    public void initialize(){
        userService = (UserServiceImpl) ServiceRegistry.getInstance().getService("userService");
        errorMsg.setVisible(false);
    }
    @FXML
    private Text errorMsg;


    @FXML
    private TextField userField;

    @FXML
    private PasswordField passField;

    @FXML
    void onSubmit(ActionEvent event) {
        if(userService.authenticate(userField.getText(), passField.getText())){
            Navigation.getInstance().load("help");
        }

        errorMsg.setVisible(true);

    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }


}