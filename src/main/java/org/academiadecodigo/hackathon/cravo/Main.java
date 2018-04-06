package org.academiadecodigo.hackathon.cravo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.academiadecodigo.hackathon.cravo.services.*;
import org.academiadecodigo.hackathon.cravo.views.Navigation;

import java.io.File;


public class Main extends Application {

	private static final String VIEW_PATH = "/views/";


	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		ServiceRegistry.getInstance().addService(OrderService.class.getSimpleName(), new OrderService());

		Navigation navigation = Navigation.getInstance();
		navigation.setStage(primaryStage);
		navigation.load("mainMenu");


		Media media = new Media(getClass().getResource("/audio/adeus.mp3").toURI().toString());
		System.out.println(media);
		MediaPlayer player = new MediaPlayer(media);
		player.play();


		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/mainMenu.fxml"));
		Parent root = fxmlLoader.load();
		fxmlLoader.getController();
		System.out.println(fxmlLoader.getNamespace());

		Bootstrap bootstrap = new Bootstrap();
		bootstrap.init();


	}

}
