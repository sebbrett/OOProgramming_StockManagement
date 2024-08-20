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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Alert.AlertType;
import modules.Product;

public class AddOrDeductStockSceneController extends BaseController implements Initializable{
	@FXML
	private Label dateTimeLabel;
	@FXML
	private ListView<String> productsListView;
	@FXML
	private Spinner<Integer> modifyStockSpinner;
	@FXML
	private Label resultLabel, userLabel, productLabel;
	
	Product currentProduct;
	
	int modifyValue;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {    
    	//Setting up date and time
    	setDateTime(dateTimeLabel);
    	
		//Setting up current user
		userLabel.setText("Current User: " + StockManagement.getCurrentUser().getUserID());
        
    	//Initializing the spinner
    	SpinnerValueFactory<Integer> valFac = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100);
    	modifyStockSpinner.setValueFactory(valFac);
    	modifyStockSpinner.getValueFactory().setValue(1);
    	
    	//Initializing productsListView
    	for(int i = 0 ; i < StockManagement.getNoOfProducts() ; i++) {
    		//Discontinued product will not be shown
    		currentProduct = StockManagement.getProduct(i);
    		if(currentProduct.getProdStat()) {
    			String str = currentProduct.getProdNum() + "\t" + currentProduct.getProdName();
    			productsListView.getItems().add(str);
    		}
    	}	
    	productsListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				String str = productsListView.getSelectionModel().getSelectedItem();
				int i = str.indexOf('\t');
				String productNum = str.substring(0, i);
				Product product = StockManagement.getProduct(productNum);
				
				if(product!=null) {
					productLabel.setText(product.toString());
				}
				else
					productLabel.setText("Error, unable to display product details.");
			}
		});
    	
    }
    public void confirmModifyAlert(ActionEvent event, Spinner <Integer> s) throws IOException {
		Alert alert = new Alert(AlertType.CONFIRMATION);
	    alert.setTitle("Confirm Continue");
        alert.setHeaderText("Continue modifying stock(s) ?");
		alert.setContentText("Press OK to continue modifying\nPress Cancel to return to Main Menu");
		if(alert.showAndWait().get()==ButtonType.OK) {
			alert.close();
			s.getValueFactory().setValue(1);
			
		}
		else
			switchToScene(event, "MainMenu.fxml");
		
	}

    
    public void modifyQuantity(ActionEvent event, int changeAmount, String modificationType, String message) {
        // Parsing the product number from the selected row
        String str = productsListView.getSelectionModel().getSelectedItem();
        int i = str.indexOf('\t');
        String productNum = str.substring(0, i);

        // Get the product via the extracted productNum
        Product product = StockManagement.getProduct(productNum);

        // Determine the modification type and perform the corresponding modification
        if(modificationType.equals("DEDUCT")) {
        	if(changeAmount > product.getProdStockQuan()) {
        		resultLabel.setText("Error, deduct value is larger than remaining value!");
        		System.out.println("Error Detected");
        	}
        	else{
        		product.setProdStockQuan(product.getProdStockQuan() - changeAmount);
        		resultLabel.setText(message);
        	}
        }
        else {
        	product.setProdStockQuan(product.getProdStockQuan() + changeAmount);
        	resultLabel.setText(message);
        }
    }
    

    public void deductQuantity(ActionEvent event) throws IOException {
    	int amount = modifyStockSpinner.getValue();	
        modifyQuantity(event, amount, "DEDUCT", "Stock Deducted Successfully!"); 
        refreshDetail();
        delay(1000, () -> {
			try {
				confirmModifyAlert(event, modifyStockSpinner);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
    }
    
    

    public void addQuantity(ActionEvent event) throws IOException {
    	int amount = modifyStockSpinner.getValue();
        modifyQuantity(event, amount,"ADD", "Stock Added Successfully!"); 
        refreshDetail();
        delay(1000, () -> {
			try {
				confirmModifyAlert(event, modifyStockSpinner);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
       
    }
    
    private void refreshDetail() {
	    String selectedProduct = productsListView.getSelectionModel().getSelectedItem();
	    if (selectedProduct == null) {
	        System.out.println("Error: No product selected.");
	        return;
	    }

	    int i = selectedProduct.indexOf('\t');
	    String productNum = selectedProduct.substring(0, i);
	    Product product = StockManagement.getProduct(productNum);

	    if (product != null) {
	        productLabel.setText(product.toString());
	       
	    } else {
	    	productLabel.setText("Product not found!");
	    }
    }
   
	public void switchToMainMenu(ActionEvent event) throws IOException{
		switchToScene(event,"MainMenu.fxml");
    }
}


