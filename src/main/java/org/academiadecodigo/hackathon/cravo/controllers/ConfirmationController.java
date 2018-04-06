package org.academiadecodigo.hackathon.cravo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import org.academiadecodigo.hackathon.cravo.services.ServiceRegistry;
import org.academiadecodigo.hackathon.cravo.services.OrderService;
import org.academiadecodigo.hackathon.cravo.views.Navigation;

import java.util.Map;

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
        orderService = (OrderService) ServiceRegistry.getInstance().getService(OrderService.class.getSimpleName());
        Map<String, Integer> orders = orderService.getOrders();
        StringBuilder sb = new StringBuilder();
        for (String s : orders.keySet()) {
            sb.append("Confirm you want to donate ");
            sb.append(orders.get(s));
            sb.append(" ");
            sb.append(s);
            sb.append("?\n");
        }

        received_text.setText(sb.toString());

        orderService.emptyMap();

    }

    @FXML
    void onCancel(ActionEvent event) {

        Navigation.getInstance().load("select");
    }

    @FXML
    void onConfirm(ActionEvent event) {

        //TODO interaction with the database (table=offers)
        Navigation.getInstance().load("currentitems");
    }

}
