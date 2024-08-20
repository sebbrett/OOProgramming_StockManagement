package controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BaseController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void switchToScene(Event event, String sceneName) throws IOException {
	    root = FXMLLoader.load(getClass().getResource(sceneName));
	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	    scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();
	}
	public void setDateTime(Label label) {
		 Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
	            LocalTime currentTime = LocalTime.now();
	            DateTimeFormatter tformatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	            String formattedTime = currentTime.format(tformatter);
	            LocalDate currentDate = LocalDate.now();
	            DateTimeFormatter Dformatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	            String formattedDate = currentDate.format(Dformatter);
	            label.setText(formattedTime + "\t" + formattedDate);
		    }));
		    timeline.setCycleCount(Animation.INDEFINITE);
	        timeline.play();
	}
	
	// source code for delaying codes
	// Source : https://stackoverflow.com/questions/26454149/make-javafx-wait-and-continue-with-code 
	public static void delay(long millis, Runnable continuation) {
	      Task<Void> sleeper = new Task<Void>() {
	          @Override
	          protected Void call() throws Exception {
	              try { Thread.sleep(millis); }
	              catch (InterruptedException e) { }
	              return null;
	          }
	      };
	      sleeper.setOnSucceeded(event -> continuation.run());
	      new Thread(sleeper).start();
	    }
	
	
	public Stage getStage() {
		return this.stage;
	}

	public Scene getScene() {
		return scene;
	}
	public Parent getRoot() {
		return root;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	public void setRoot(Parent root) {
		this.root = root;
	}
}
