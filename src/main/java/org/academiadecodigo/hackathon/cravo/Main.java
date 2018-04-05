package org.academiadecodigo.hackathon.cravo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main extends Application{
    
    public static void main(String[] args) {

        launch(args);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cravo");

        EntityManager em = emf.createEntityManager();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxml_example.fxml"));

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);

        gridPane.setGridLinesVisible(false);

        Image image = new Image(getClass().getResourceAsStream(""));
        Scene scene = new Scene(gridPane, 500, 500);
        Label title = new Label("xxxxxxx");


        Navigation navigation = Navigation.getInstance();
        navigation.setStage(primaryStage);
        navigation.load("main");
    }
}
