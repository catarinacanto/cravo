package org.academiadecodigo.hackathon.cravo.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.academiadecodigo.hackathon.cravo.ServiceRegistry;
import org.academiadecodigo.hackathon.cravo.services.OrderService;
import org.academiadecodigo.hackathon.cravo.views.Navigation;

import javax.persistence.criteria.CriteriaBuilder;

public class SelectController implements Controller {

    private OrderService orderService;

    @FXML
    private SplitMenuButton food;

    @FXML
    private SplitMenuButton medicine;

    @FXML
    private TextField food_amt;

    @FXML
    private TextField medicine_amt;

    @FXML
    private TextField money_amt;

    @FXML
    void initialize() {
        orderService = (OrderService) ServiceRegistry.getInstance().get(OrderService.class.getSimpleName());
    }

    @FXML
    void onSubmit(ActionEvent event) {
        if (!food.getText().equals("Food")){
            orderService.putOrder(food.getText(), Integer.parseInt(food_amt.getText()));
        }
        if (!medicine.getText().equals("Medicine")){
            orderService.putOrder(medicine.getText(), Integer.parseInt(medicine_amt.getText()));
        }

        if (!money_amt.getText().equals("")) {
            orderService.putOrder("money", Integer.parseInt(money_amt.getText()));
        }

        Navigation.getInstance().load("confirmation");

    }

    @FXML
    private Text money;

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


    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}

