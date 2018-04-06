package org.academiadecodigo.hackathon.cravo.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.academiadecodigo.hackathon.cravo.controllers.Controller;

public class Navigation {

    private static final String VIEW_PATH = "/views/";
    private static Navigation instance;
    private Stage stage;

    private LinkedList<Scene> history;

    public Map<String, Controller> getControllerMap() {
        return controllerMap;
    }

    private Navigation() {
        history = new LinkedList<>();
    }

    private Map<String, Controller> controllerMap = new HashMap<>();

    public static Navigation getInstance() {

        if (instance == null) {
            instance = new Navigation();
        }

        return instance;
    }

    public void load(String view) {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(VIEW_PATH + view + ".fxml"));
            Parent root = fxmlLoader.load();

            controllerMap.put(view, fxmlLoader.<Controller>getController());

            Scene scene = new Scene(root, 1024, 768);

            stage.setScene(scene);
            stage.show();

            history.push(scene);

        } catch (IOException e) {
            System.err.println("Unable to load view " + view + e.getMessage());
            e.printStackTrace();
        }
    }

    public void back() {

        if (history.size() <= 1) {
            return;
        }

        history.pop();

        stage.setScene(history.peek());
        stage.show();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }


}
