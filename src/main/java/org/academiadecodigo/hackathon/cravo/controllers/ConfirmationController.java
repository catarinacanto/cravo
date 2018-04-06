package org.academiadecodigo.hackathon.cravo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import org.academiadecodigo.hackathon.cravo.ServiceRegistry;
import org.academiadecodigo.hackathon.cravo.services.OrderService;
import org.academiadecodigo.hackathon.cravo.views.Navigation;

public class ConfirmationController implements Controller {

    private OrderService orderService;

    @FXML
    private Text confirmation;

    @FXML
    public Text received_text;

    @FXML
    private Button cancel_button;

    @FXML
    private Button confirm_button;

    @FXML
    void initialize() {
        orderService = (OrderService) ServiceRegistry.getInstance().get(OrderService.class.getSimpleName());
        received_text.setText(orderService.getOrders().get("batata").toString());
    }

    @FXML
    void onCancel(ActionEvent event) {

        Navigation.getInstance().load("select");
    }

    @FXML
    void onConfirm(ActionEvent event) {

        //TODO interaction with the database (table=offers)
        Navigation.getInstance().load("select");
    }

}
