package application;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import modules.Phone;
import modules.Product;
import modules.Refrigerator;
import modules.TV;
import modules.UserInfo;

public class StockManagement extends Application {
	
	public final static int MAX_USER = 6;
	private static ArrayList<Product> products = new ArrayList<Product>();	
	private static UserInfo[] users = new UserInfo[MAX_USER];
	private static int noOfUsers;
	private static UserInfo currentUser;
	
	//Method that retrieves a product from products array based on given index
	public static Product getProduct(int position) {
		if(position<products.size())
			return products.get(position);
		//Returns NULL if invalid index is given
		return null;
	}
	
	//Method that retrieves a product from products array based on given prodNo 
	public static Product getProduct(String prodNo) {
		for(int i = 0 ; i < products.size(); i++) {
			if(products.get(i).getProdNum().equals(prodNo)){
				return products.get(i);
			}
		}
		//Returns NULL if invalid product number is given
		return null;
	}
	
	//Method that returns the number of current products
	public static int getNoOfProducts() {
		return products.size();
	}
	
	//Method that allows user to add a product to the products array list
	public static boolean addProduct(Product p) {
		if( p != null) {
			products.add(p);
			return true;
		}
		return false;
	}
	
	//Getter for currentUser
	public static UserInfo getCurrentUser() {
		return currentUser;
	}
	
	//Setter for currentUser
	public static void setCurrentUser(UserInfo currentUser) {
		StockManagement.currentUser = currentUser;
	}
	
	//Getter for current noOfUsers
	public static int getNoOfUsers () {
		return noOfUsers;	
	}
	
	//Setter for current noOfUsers
	public static void setNoOfUsers (int noOfUsers) {
		StockManagement.noOfUsers = noOfUsers;
	}
	
	//Method that retrieves a user from users array based on index given
	public static UserInfo getUser(int position) {
		return users[position];
	}
	
	//Method that retrieves a user from users array based on userID given
	public static UserInfo getUser(String userID) {
		for(int i = 0; i < MAX_USER; i++) {
			if(users[i].getUserID().equals(userID)) {
				return users[i];
			}
		}
		return null;
	}
	
	//Method that checks the existence of user in users array
	public static boolean isExistedUser(String userID) {
		for(int i = 0 ; i < MAX_USER; i ++) {
			if(users[i].getUserID().equals(userID))
				return true;
		}
		return false;
	}
	
	//Method that adds a user to the users array
	public static boolean addUser(UserInfo u) {
		//Remember to add a sorting feature
		for(int i = 0; i < MAX_USER; i++) {
			if(users[i] == null) {
				users[i] = u;
				noOfUsers++;
				return true;
			}
		}
		return false;
	}
	
	
	
	@Override
	public void start(Stage pStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/controllers/Login.fxml"));
			Scene scene = new Scene(root);
			//Image icon = new Image(getClass().getResourceAsStream("catLogo.jpeg"));
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
			pStage.setMinHeight(600);
			pStage.setMinWidth(1000);
			pStage.setScene(scene);
			pStage.setTitle("Heng Huat Stock Management System");
			//pStage.getIcons().add(icon); 
			pStage.show();
			
			pStage.setOnCloseRequest(e -> {
				e.consume();
				exit(pStage);
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void exit(Stage stage) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
	    alert.setTitle("Exit Confirmation");
        alert.setHeaderText("Exit Program");
		alert.setContentText("Are you sure you want to exit?");
		
		if(alert.showAndWait().get()==ButtonType.OK) {
			stage.close();
		}
	}
	
	public static void main(String[] args) {
		//Codes below are solely for function testing, cqin, 20.4.2024
		addProduct(new Refrigerator("1","Panasonic Fridge",10,2088.99,"Single-door","Silver",20));
		addProduct(new Refrigerator("2","Hisense Fridge",10,3999.99,"Double-door","White",20));
		addProduct(new TV("3","XiaoMi TV",10,3999.99,"LED","4K","55 inch"));
		addProduct(new Refrigerator("4","Panasonic Fridge",10,2088.99,"Single-door","Silver",20));
		addProduct(new Refrigerator("5","Hisense Fridge",10,3999.99,"Double-door","White",20));
		addProduct(new TV("6","XiaoMi TV",10,3999.99,"LED","4K","55 inch"));
		addProduct(new Refrigerator("7","Panasonic Fridge",10,2088.99,"Single-door","Silver",20));
		addProduct(new Refrigerator("8","Hisense Fridge",10,3999.99,"Double-door","White",20));
		addProduct(new TV("9","XiaoMi TV",10,3999.99,"LED","4K","55 inch"));
		addProduct(new TV("10","XiaoMi TV",10,3999.99,"LED","4K","55 inch"));
		addProduct(new Refrigerator("11","Panasonic Fridge",10,2088.99,"Single-door","Silver",20));
		addProduct(new Refrigerator("12","Hisense Fridge",10,3999.99,"Double-door","White",20));
		addProduct(new TV("13","XiaoMi TV",10,3999.99,"LED","4K","55 inch"));
		addProduct(new Phone("14", "Iphone", 89, 4999.99, "Apple", "15 Pro Max",256));
		
		addUser(new UserInfo("Bester Loo", UserInfo.generateUserID("Bester Loo")));
		addUser(new UserInfo("Chee Qin Kam", UserInfo.generateUserID("Chee Qin Kam")));
		addUser(new UserInfo("Jun Jie Koh", UserInfo.generateUserID("Jun Jie Koh")));
		addUser(new UserInfo("Zi Hin Loh", UserInfo.generateUserID("Zi Hin Loh")));
		
		launch(args);
	}
}
