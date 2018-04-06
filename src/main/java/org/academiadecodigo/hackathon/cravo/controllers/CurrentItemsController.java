package org.academiadecodigo.hackathon.cravo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import org.academiadecodigo.hackathon.cravo.model.item.Item;
import org.academiadecodigo.hackathon.cravo.model.transactions.Offer;
import org.academiadecodigo.hackathon.cravo.services.*;
import org.academiadecodigo.hackathon.cravo.views.Navigation;

import java.util.LinkedList;
import java.util.List;

public class CurrentItemsController {

    private UserServiceImpl userService;
    private ItemServiceImpl itemService;
    private OfferDataBaseService offerService;
    private LinkedList<Text> optTexts;
    private LinkedList<Text> amounts;

    @FXML
    void initialize(){

        optText1.setVisible(false);
        optText2.setVisible(false);
        optText3.setVisible(false);
        optText4.setVisible(false);
        amount1.setVisible(false);
        amount2.setVisible(false);
        amount3.setVisible(false);
        amount4.setVisible(false);
        userService = (UserServiceImpl) ServiceRegistry.getInstance().getService("userService");
        itemService = (ItemServiceImpl) ServiceRegistry.getInstance().getService("itemService");
        offerService = (OfferDataBaseService) ServiceRegistry.getInstance().getService("offerDataBaseService");

        optTexts = new LinkedList<>();
        optTexts.add(optText1);
        optTexts.add(optText2);
        optTexts.add(optText3);
        optTexts.add(optText4);

        amounts = new LinkedList<>();
        amounts.add(amount1);
        amounts.add(amount2);
        amounts.add(amount3);
        amounts.add(amount4);

        findItems();

    }

    @FXML
    private Text optText2;

    @FXML
    private Text optText1;

    @FXML
    private Text optText3;

    @FXML
    private Text optText4;

    @FXML
    private Text amount1;

    @FXML
    private Text amount2;

    @FXML
    private Text amount3;

    @FXML
    private Text amount4;

    @FXML
    private Button backButton;

    @FXML
    void back(ActionEvent event) {

        Navigation.getInstance().load("help");

    }

    private void findItems(){
        CurrentUserService userService = (CurrentUserService)ServiceRegistry.
                getInstance().getService("CurrentUserService");

        Integer currentUserId = userService.getCurrentUser().getId();
        System.out.println("USER ID" + currentUserId);

        List<Item> itemList = itemService.list();
        List<Offer> offerList = offerService.list();

        int count = 0;

        for (Offer offer : offerList) {

            if (count == 3){
                break;
            }

            if (offer.getUser().getId().equals(currentUserId)){

                optTexts.get(count).setText(itemList.get(offer.getItem().getId()).getName());
                optTexts.get(count).setVisible(true);
                amounts.get(count).setText(offer.getAmount().toString());
                amounts.get(count).setVisible(true);

                count++;
            }

        }

    }


}