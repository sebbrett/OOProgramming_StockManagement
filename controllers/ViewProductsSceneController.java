package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.StockManagement;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import modules.Product;

public class ViewProductsSceneController extends BaseController implements Initializable{
	@FXML
	private ListView<String> productsListView;
	@FXML
	private Label productDetailsLabel;
	@FXML
	private Label dateTimeLabel;
	@FXML
	private Label userLabel;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//Setting up the date and time
		setDateTime(dateTimeLabel);
		
		//Setting up current user
		userLabel.setText("Current User: " + StockManagement.getCurrentUser().getUserID());
		
		//Setting up the content to be displayed at productsListView
		for(int i = 0 ; i < StockManagement.getNoOfProducts();i++) {
			String temp = StockManagement.getProduct(i).getProdNum() + "\t" + StockManagement.getProduct(i).getProdName();
			productsListView.getItems().add(temp);
		}
		
		//Setting up the content to be displayed at productDetailsLabel if user clicks a product at productListView
		productsListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				String str = productsListView.getSelectionModel().getSelectedItem();
				int i = str.indexOf('\t');
				String productNum = str.substring(0, i);
				Product product = StockManagement.getProduct(productNum);
				
				if(product!=null) {
					productDetailsLabel.setText(product.toString());
				}
				else
					productDetailsLabel.setText("Error, unable to display product details.");
			}
		});
	}
	
	public void switchToMainMenu(ActionEvent e) throws IOException  {
		switchToScene(e,"MainMenu.fxml");
	}
}

