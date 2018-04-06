package org.academiadecodigo.hackathon.cravo.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import org.academiadecodigo.hackathon.cravo.model.transactions.Offer;
import org.academiadecodigo.hackathon.cravo.services.AbstractService;
import org.academiadecodigo.hackathon.cravo.services.OfferServiceImpl;
import org.academiadecodigo.hackathon.cravo.views.Navigation;
import org.academiadecodigo.hackathon.cravo.views.ServiceRegistry;

public class HelpController {

    private OfferServiceImpl offerService;

    @FXML
    private Text offerText;

    @FXML
    void need(ActionEvent event) {
        Navigation.getInstance().load("select");
    }

    @FXML
    void offer(ActionEvent event) {
        Navigation.getInstance().load("select");
    }

    public void initialize(){

        offerService = (OfferServiceImpl) ServiceRegistry.getService("offerService");
    }


    public void setOfferService(OfferServiceImpl offerService) {
        this.offerService = offerService;
    }
}
