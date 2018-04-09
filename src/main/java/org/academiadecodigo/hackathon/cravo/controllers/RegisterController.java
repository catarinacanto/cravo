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


    public UserRegisterServiceImpl getUserRegisterService() {
        return userRegisterService;
    }

    public SendEmail getMailer() {
        return mailer;
    }

    public void setMailer(SendEmail mailer) {
        this.mailer = mailer;
    }

    public void setUserField(TextField userField) {
        this.userField = userField;
    }

    public void setPassField(PasswordField passField) {
        this.passField = passField;
    }

    public TextField getEmailField() {
        return emailField;
    }

    public MenuButton getCheckBoxText() {
        return checkBoxText;
    }

    public void setCheckBoxText(MenuButton checkBoxText) {
        this.checkBoxText = checkBoxText;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    @FXML
    void onSubmit(ActionEvent event) {


        String username = userField.getText();

        System.out.println(this);
        UserRegisterServiceImpl userRegisterService =
                (UserRegisterServiceImpl) ServiceRegistry.getInstance().getService("userRegistryService");

        if (!userRegisterService.userExists(username)) {
            System.out.println(emailField);
            User user = new User(userField.getText(), passField.getText(), emailField.getText());
            System.out.println(user);
            userRegisterService.registerUser(user);

            mailer.register(emailField.getText(), userField.getText());

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

    public void onReturn(ActionEvent actionEvent) {
        Navigation.getInstance().load("mainMenu");
    }

    public void setEmailField(TextField emailField) {
        this.emailField = emailField;
    }
}


