package org.academiadecodigo.hackathon.cravo.controllers;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.academiadecodigo.hackathon.cravo.model.item.Item;
import org.academiadecodigo.hackathon.cravo.services.ItemServiceImpl;
import org.academiadecodigo.hackathon.cravo.services.OrderService;
import org.academiadecodigo.hackathon.cravo.services.ServiceRegistry;
import org.academiadecodigo.hackathon.cravo.views.Navigation;

import javax.swing.event.HyperlinkEvent;
import java.util.List;

public class SelectController implements Controller {

	private OrderService orderService;
	private ItemServiceImpl itemService;

	private MenuItem menuItem;

	@FXML
	private TextField food_amt;

	@FXML
	private TextField money_amt;

	@FXML
	private Text money;

	@FXML
	private SplitMenuButton food;

	@FXML
	void initialize() {
		orderService = (OrderService) ServiceRegistry.getInstance().getService(OrderService.class.getSimpleName());

		itemService = (ItemServiceImpl) ServiceRegistry.getInstance().getService(ItemServiceImpl.class.getSimpleName());

		update();
	}

	private void update() {

		List<Item> items = itemService.list();

		for (Item item : items) {
			food.getItems().addAll(menuItem = new MenuItem(item.getName()));

            menuItem.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    food.setText(item.getName());
                }
            });
        }
    }

	@FXML
	void onSubmit(ActionEvent event) {

		if (!food.getText().equals("Food")) {
			orderService.putOrder("kg of " + food.getText(), Integer.parseInt(food_amt.getText()));
			System.out.println(food.getText());
		}

		if (!money_amt.getText().equals("")) {
			orderService.putOrder("€", Integer.parseInt(money_amt.getText()));
		}

		Navigation.getInstance().load("confirmation");

	}

    @FXML
	void setFood(ActionEvent actionEvent) {
	}
}

