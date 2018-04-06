package org.academiadecodigo.hackathon.cravo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.academiadecodigo.hackathon.cravo.controllers.MainController;
import org.academiadecodigo.hackathon.cravo.views.Navigation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;

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

    }
}
