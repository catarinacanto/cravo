package org.academiadecodigo.hackathon.cravo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;

public class Navigation {

    private static final String VIEW_PATH = "/org/academiadecodigo/hackathon/cravo/javafx";
    private static Navigation instance;
    private Stage stage;
    private LinkedList<Scene> history = new LinkedList<Scene>();


    public void load(String view) {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(VIEW_PATH + view + ".fxml"));
            Parent root = fxmlLoader.load();

            Scene scene = new Scene(root, 1000, 640);

            stage.setScene(scene);
            stage.show();

            history.push(scene);

        } catch (IOException e) {
            System.err.println("Unable to load view " + view + e.getMessage());
            e.printStackTrace();
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public static Navigation getInstance() {

        if (instance == null) {
            instance = new Navigation();
        }
        return instance;

    }
}
