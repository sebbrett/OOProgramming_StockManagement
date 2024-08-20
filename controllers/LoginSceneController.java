package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.StockManagement;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import modules.UserInfo;

public class LoginSceneController extends BaseController implements Initializable{
    @FXML
    private TextField fullNameTextField;
    @FXML
    private Label dateTimeLabel;
    @FXML
    private Label remainingQuotaLabel;
    @FXML
    private Label currentUsersLabel;
    
    private String fullName;
    private String userID;
    
    
    public void initialize(URL arg0, ResourceBundle arg1) {
	    //Initializing date and time
    	setDateTime(dateTimeLabel);
    	
    	//Shows remaining user quota
    	remainingQuotaLabel.setText("Remaning User Quota:\t" + Integer.toString(StockManagement.MAX_USER - StockManagement.getNoOfUsers()));
    	
    	//Shows current users
    	String currentUserNames = "";
    	for(int i = 0; i < StockManagement.MAX_USER; i++) {
    		if(StockManagement.getUser(i)!=null) {
    			currentUserNames += StockManagement.getUser(i).getFullName() + "\n";
    		}
    	}
    	currentUsersLabel.setText("Current User(s):\n\n" + currentUserNames);
    }
    
    public void login(KeyEvent e) throws IOException {
        if (e.getCode() == KeyCode.ENTER) {
        	fullName = fullNameTextField.getText();
        	userID = UserInfo.generateUserID(fullName);
        	UserInfo u1 = new UserInfo(fullName, userID);
        	if(StockManagement.isExistedUser(userID)){
        		//Grant user login if the entered user is a valid user within the system
        		StockManagement.setCurrentUser(StockManagement.getUser(userID));
        		switchToScene(e,"mainMenu.fxml");
        		}
        	
        		
        	
        }
        
    }
}