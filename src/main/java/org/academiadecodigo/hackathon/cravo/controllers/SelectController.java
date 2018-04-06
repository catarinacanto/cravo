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

public class SelectController implements Controller {

    private OrderService orderService;

    @FXML
    private SplitMenuButton food;

    @FXML
    private SplitMenuButton medicine;

    @FXML
    void initialize() {
        orderService = (OrderService) ServiceRegistry.getInstance().get(OrderService.class.getSimpleName());
    }

    @FXML
    void onSubmit(ActionEvent event) {
        orderService.putOrder("batata");
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

    @FXML
    private TextField food_amt;

    @FXML
    private TextField medicine_amt;

    @FXML
    private TextField money_amt;

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}

