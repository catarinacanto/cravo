package org.academiadecodigo.hackathon.cravo.controllers;


import javafx.event.ActionEvent;
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

import java.util.List;

public class SelectController implements Controller {
	
	private OrderService orderService;
	private ItemServiceImpl itemService;
	
	private MenuItem menuItem;
	
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
	private SplitMenuButton time;
	
	@FXML
	private TextField time_amt;
	@FXML
	private Text money;
	
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
			medicine.getItems().addAll(new MenuItem(item.getName()));
			time.getItems().addAll(new MenuItem(item.getName()));
		}
	}
	
	@FXML
	void onSubmit(ActionEvent event) {
		
		if (!food.getText().equals("Food")) {
			orderService.putOrder("kg of " + food.getText(), Integer.parseInt(food_amt.getText()));
			System.out.println(food.getText());
		}
		if (!medicine.getText().equals("Medicine")) {
			orderService.putOrder(medicine.getText(), Integer.parseInt(medicine_amt.getText()));
		}
		
		if (!time.getText().equals("Time")) {
			orderService.putOrder(time.getText() + " hours", Integer.parseInt(time_amt.getText()));
		}
		
		if (!money_amt.getText().equals("")) {
			orderService.putOrder("€", Integer.parseInt(money_amt.getText()));
		}
		
		Navigation.getInstance().load("confirmation");
		
	}
	
	@FXML
	void setPotatoes(ActionEvent event) {
		food.setText(menuItem.getText());
	}
	
	@FXML
	void setRice(ActionEvent event) {
		food.setText("rice");
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
	void setConstruction(ActionEvent event) {
		time.setText("Construction ");
	}
	
	@FXML
	void setTeaching(ActionEvent event) {
		time.setText("Teaching ");
	}
	
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
}

