package org.academiadecodigo.hackathon.cravo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.academiadecodigo.hackathon.cravo.controllers.RegisterController;
import org.academiadecodigo.hackathon.cravo.views.Navigation;


public class Main extends Application {

    private static final String VIEW_PATH = "/views/";


    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Navigation navigation = Navigation.getInstance();
        navigation.setStage(primaryStage);
        navigation.load("mainMenu");


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/mainMenu.fxml"));
        Parent root = fxmlLoader.load();
        fxmlLoader.getController();
        System.out.println(fxmlLoader.getNamespace());

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.init();





        // TODO: Delete these sample queries:

        //UserServiceImpl userService = new UserServiceImpl(emf);
        //ItemServiceImpl itemService = new ItemServiceImpl(emf);
        //DemandServiceImpl demandService = new DemandServiceImpl(emf);
        //OfferServiceImpl offerService = new OfferServiceImpl(emf);

        /*List<User> userList = userService.list();
        List<Item> itemList = itemService.list();
        List<Demand> demandList = demandService.list();
        List<Offer> offerList = offerService.list();*/

   /*     Demand demand1 = demandList.get(1);

        Item itemRequested = demand1.getItem();
        User userRequesting = demand1.getUser();

        for (Offer offer : offerList) {
            if (offer.getItem().getId().equals(itemRequested.getId())){

                System.out.println("found an item:" + itemRequested);
                System.out.println("in offers: " + offer.getItem());

            }
        }*/

    }

}
