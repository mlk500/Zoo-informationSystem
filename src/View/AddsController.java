package View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Utils.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AddsController implements Initializable{
	@FXML
	private Button backbtn;
    @FXML
    void AddBird(ActionEvent event) {//in here i created all of the button for adds and if a button gets pressed we will be taken to the add bird screen
    	try {
    	Parent root = FXMLLoader.load(getClass().getResource("AddBird.fxml"));
		root.setStyle("-fx-background-image: url('imgs/birds.jpg');"+"-fx-background-size:cover");
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
		}
		catch (IOException e) {
			Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
		}
    	}

    @FXML
    void AddEmployee(ActionEvent event) {//if the button gets pressed we will be taken to add new employee
    	try {
    	Parent root = FXMLLoader.load(getClass().getResource("AddNewZooEmployee.fxml"));
		root.setStyle("-fx-background-image: url('imgs/zooEmployees.jpg');"+"-fx-background-size:cover");
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
    }
    	catch (IOException e) {
			Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
		}
    	}

    @FXML
    void AddMammal(ActionEvent event) {
    	try {
    	Parent root = FXMLLoader.load(getClass().getResource("addMammal.fxml"));
		root.setStyle("-fx-background-image: url('imgs/mammals.jpg');"+"-fx-background-size:cover");
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
    }
    	catch (IOException e) {
			Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
		}
    	}

    @FXML
    void AddReptile(ActionEvent event){
    	try {
    	Parent root = FXMLLoader.load(getClass().getResource("AddReptile.fxml"));
		root.setStyle("-fx-background-image: url('imgs/reptiles.jpg');"+"-fx-background-size:cover");
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
    }
    	catch (IOException e) {
			Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
		}
    	}


    @FXML
    void AddSection(ActionEvent event){
    	try {
    	Parent root = FXMLLoader.load(getClass().getResource("AddSection.fxml"));
		root.setStyle("-fx-background-image: url('imgs/sections.jpg');"+"-fx-background-size:cover");
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
    }
    catch (IOException e) {
		Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
	}
	}

    @FXML
    void AddSnack(ActionEvent event) {
    	try {
    	Parent root = FXMLLoader.load(getClass().getResource("AddSnack.fxml"));
		root.setStyle("-fx-background-image: url('imgs/snacks.gif');"+"-fx-background-size:cover");
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
    }
    catch (IOException e) {
		Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
	}
	}


    @FXML
    void AddSnackBar(ActionEvent event) {
    	try {
    	Parent root = FXMLLoader.load(getClass().getResource("AddSnackBar.fxml"));
		root.setStyle("-fx-background-image: url('imgs/snackBar.jpg');"+"-fx-background-size:cover");
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
    }
    catch (IOException e) {
		Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
	}
	}


    @FXML
    void AddVisitor(ActionEvent event) {
    	try {
    	Parent root = FXMLLoader.load(getClass().getResource("AddVisitor.fxml"));
		root.setStyle("-fx-background-image: url('imgs/visitors.jpg');"+"-fx-background-size:cover");
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
    }
    	 catch (IOException e) {
    			Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
    		}
    		}
    
    public void back(ActionEvent event) {
		if(ControllScenes.getType().equals(Users.ADMIN)) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("AdminWindow.fxml"));
    		root.setStyle("-fx-background-image: url('imgs/safari3.jpg');"+"-fx-background-size:cover");
    		Scene adminScene = new Scene(root);
    		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		window.setScene(adminScene);
    		window.show();
		} catch (IOException e) {
			Alerts.alertBox(AlertType.ERROR, "Back", "Could not go back!", "");
		}
		}
		

	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Image img = new Image("imgs/back.png", 66, 25, true, false);
		backbtn.setGraphic(new ImageView(img));
		
	}


}


