package controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import application.StockManagement;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class LogoutSceneController extends BaseController {
	@FXML
	private Label message;
	@FXML
	private Label welcome;
	
	public void initialize() throws IOException {
		LocalTime currentTime = LocalTime.now();
        DateTimeFormatter tformatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = currentTime.format(tformatter);
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter Dformatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(Dformatter);
        message.setText("User: " + StockManagement.getCurrentUser().getUserID() + "\nLogout time: "+formattedTime+"  "+formattedDate+"\n\nPress Enter to return!");
	}
	public void backToLogin(KeyEvent e) throws IOException {
        if (e.getCode() == KeyCode.ENTER) {
        	switchToScene(e,"login.fxml");
        }
    }
}



