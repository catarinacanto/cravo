package org.academiadecodigo.hackathon.cravo.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import org.academiadecodigo.hackathon.cravo.services.OfferServiceImpl;
import org.academiadecodigo.hackathon.cravo.views.Navigation;
import org.academiadecodigo.hackathon.cravo.services.ServiceRegistry;

public class HelpController implements Controller {

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

        offerService = (OfferServiceImpl) ServiceRegistry.getInstance().getService("offerService");
    }


    public void setOfferService(OfferServiceImpl offerService) {
        this.offerService = offerService;
    }
}
