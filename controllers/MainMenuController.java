package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.StockManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MainMenuController extends BaseController implements Initializable{
	@FXML
	private Button logoutButton;
	@FXML
	private VBox mainMenuPane;
	@FXML
	private Label dateTimeLabel;    
	@FXML 
	private Label userLabel;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Setting up the date and time
		setDateTime(dateTimeLabel);
		
		//Setting up current user
		userLabel.setText("Current User: " + StockManagement.getCurrentUser().getUserID());
	}

	public void switchToViewProducts(ActionEvent e) throws IOException  {
		switchToScene(e,"ViewProducts.fxml");
	}
	public void switchToAddProduct(ActionEvent e) throws IOException{
		switchToScene(e, "AddProduct.fxml");
	}
	public void switchToAddOrDeductStock(ActionEvent e) throws IOException {
		switchToScene(e,"AddOrDeductStock.fxml");
	}
	
	public void switchToDiscontinueProduct(ActionEvent e) throws IOException {
		switchToScene(e,"DiscontinueProduct.fxml");
	}
	
	public void logout(ActionEvent e) throws IOException {
		Alert alert = new Alert(AlertType.CONFIRMATION);
	    alert.setTitle("Logout Confirmation");
        alert.setHeaderText("Logout Heng Huat Stock Management System");
		alert.setContentText("Are you sure you want to logout?");
		
		if(alert.showAndWait().get()==ButtonType.OK) {
			//StockManagement.usrCount++;
			switchToScene(e, "Logout.fxml");
		}
	}

}
