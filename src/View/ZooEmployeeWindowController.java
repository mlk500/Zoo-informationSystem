package View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import LaunchGui.Launching;
import Model.Zoo;
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

public class ZooEmployeeWindowController implements Initializable{
	@FXML
	Button logoutBtn;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Image img = new Image("imgs/log out.png", 64, 33, true, false);
		logoutBtn.setGraphic(new ImageView(img));
		
	}//this is the main window for employee we can add remove and get and do queries

	public void addPressed(ActionEvent event) throws Exception {//go to add screen

		Parent root = FXMLLoader.load(getClass().getResource("AddForEmp.fxml"));
		root.setStyle("-fx-background-image: url('imgs/safari3.jpg');" + "-fx-background-size:cover");
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	public void removePressed(ActionEvent event) throws Exception {//go to remove screen

		Parent root = FXMLLoader.load(getClass().getResource("RemoveForEmp.fxml"));
		root.setStyle("-fx-background-image: url('imgs/safari3.jpg');" + "-fx-background-size:cover");
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	public void getPressed(ActionEvent event) throws Exception {//go to get screen

		Parent root = FXMLLoader.load(getClass().getResource("Gets.fxml"));
		root.setStyle("-fx-background-image: url('imgs/empimg.jpg');" + "-fx-background-size:cover");
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	public void queriesPressed(ActionEvent event) {//go to queries
		try {

			Parent root = FXMLLoader.load(getClass().getResource("Queries.fxml"));
			root.setStyle("-fx-background-image: url('imgs/safari3.jpg');" + "-fx-background-size:cover");
			Scene scene = new Scene(root);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		} catch (IOException e) {
			Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
		}
	}

	public void infoPressed(ActionEvent event){// go to data 
		try {
           
			Parent root = FXMLLoader.load(getClass().getResource("Data.fxml"));
			root.setStyle("-fx-background-image: url('imgs/sections.jpg');" + "-fx-background-size:cover");
			Scene scene = new Scene(root);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		} catch (IOException e) {
			Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
		}
	}

	public void revenuePressed(ActionEvent event) throws Exception {//show the revenue
		Alerts.alertBox(AlertType.INFORMATION, "Revenue", "", "Zoo Revenue: " + Zoo.getInstance().checkTotalRevenue());
	}

	public void treatPressed(ActionEvent event) throws Exception {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("AddForEmp.fxml"));
		root.setStyle("-fx-background-image: url('imgs/empimg.jpg');" + "-fx-background-size:cover");
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void visitorActionsPressed(ActionEvent event) throws Exception {
		try {//go  to visitor actions

			Parent root = FXMLLoader.load(getClass().getResource("VisitorActions.fxml"));
			root.setStyle("-fx-background-image: url('imgs/safari3.jpg');" + "-fx-background-size:cover");
			Scene scene = new Scene(root);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		} catch (IOException e) {
			// Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
			e.printStackTrace();
		}
	}

	public void animalTreatPressed(ActionEvent event) {// go to animal treated
		try {

			Parent root = FXMLLoader.load(getClass().getResource("TreatAnimal.fxml"));
			root.setStyle("-fx-background-image: url('imgs/vet.jpg');" + "-fx-background-size:cover");
			Scene scene = new Scene(root);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		} catch (IOException e) {
			Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
			//e.printStackTrace();
		}
	}
	
	
	public void logout(ActionEvent event) {//log out and save

		Launching.save();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));

            root.setStyle("-fx-background-image: url('imgs/ZooVid.gif');" + "-fx-background-size:50%");
			Scene empScene = new Scene(root);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(empScene);
			window.show();

		} catch (IOException e) {
			Alerts.alertBox(AlertType.ERROR, "Logout", "Coud not logout", " ");
		}

	}

}
