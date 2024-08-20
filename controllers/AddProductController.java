package controllers;

import java.io.IOException;

import application.StockManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import modules.Phone;
import modules.Refrigerator;
import modules.TV;

public class AddProductController extends BaseController{
	@FXML
	private Label dateTimeLabel;
	@FXML
	private ChoiceBox<String> cb;
	@FXML
	private Label f1,f2,f3;
	@FXML
	private TextField tfA,tfB,tfC,tfD,tfE,tfF ;
	@FXML
	private Spinner<Integer> quantitySpinner;
	public void initialize() {
		setDateTime(dateTimeLabel);
		cb.getItems().addAll("TV", "Refrigerator", "Phone");
		
		SpinnerValueFactory<Integer> valFac = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100);
    	quantitySpinner.setValueFactory(valFac);
    	quantitySpinner.getValueFactory().setValue(1);
	}
	public void handleChoiceChange() {
        String selectedItem = (String) cb.getValue();
        if (selectedItem != null) {
            switch (selectedItem) {
                case "TV":
                    f1.setText("Screen Type            :");
                    f2.setText("Resolution              :");
                    f3.setText("Screen Size             :" );
                    break;
                case "Refrigerator":
                    f1.setText("Door Design            : ");
                    f2.setText("Colour                      : ");
                    f3.setText("Capacity                   : " );
                    break;
                case "Phone":
                    f1.setText("Brand                       : ");
                    f2.setText("Model                      : ");
                    f3.setText("RAM                         : " );
                    break;
                default:
                    f1.setText("");
            }
        }
    }
	
	
	public void addConfirmed(ActionEvent e) throws IOException{
		if ((String) cb.getValue()=="TV") {
			TV tv = new TV(tfA.getText(),tfB.getText(),quantitySpinner.getValue(),Double.parseDouble(tfC.getText()),tfD.getText(),tfE.getText(),tfF.getText());	
			StockManagement.addProduct(tv);
		}
		else if ((String) cb.getValue()=="Refrigerator"){
			Refrigerator ref = new Refrigerator(tfA.getText(),tfB.getText(),quantitySpinner.getValue(),Double.parseDouble(tfC.getText()),tfD.getText(),tfE.getText(),Double.parseDouble(tfF.getText()));	
			StockManagement.addProduct(ref);
		}
		else if ((String) cb.getValue()=="Phone") {
			Phone phone = new Phone(tfA.getText(),tfB.getText(),quantitySpinner.getValue(),Double.parseDouble(tfC.getText()),tfD.getText(),tfE.getText(),Integer.parseInt(tfF.getText()));
			StockManagement.addProduct(phone);
		}
		Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Product Added");
        alert.setHeaderText("Product added successfully!");
		alert.setContentText("Press OK to return to main menu.");
		
		if(alert.showAndWait().get()==ButtonType.OK) {
			switchToScene(e, "MainMenu.fxml");
		}
	}
	public void switchToMenu(ActionEvent e) throws IOException {
		switchToScene(e,"mainMenu.fxml");
	}
	
}
