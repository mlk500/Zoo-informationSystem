package View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import Utils.Users;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class QueriesController implements Initializable {
	@FXML
	private ListView<String> list;
	@FXML
	private Button getBtn;
	@FXML
	private Button backbtn;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		list.getItems().add("Find all snack by worker");//add all of the queries to the list view
		list.getItems().add("Get all animals by section max visits");
		list.getItems().add("All animals by worker");
		list.getItems().add("Reptiles sleep at seasson");
		list.getItems().add("Get all discount amount");
		list.getItems().add("Get max visitors VS max workers");
		Image img = new Image("imgs/back.png", 66, 25, true, false);
		backbtn.setGraphic(new ImageView(img));

	}

	public void getQuery(ActionEvent event) {// when the button is pressed we check what did the user choose
		String selected = list.getSelectionModel().getSelectedItem();
		
		if (selected != null) {//make sure it's not null
			if (selected.equals("Find all snack by worker")) {//check what did the user choose and go the the scene according to what the user chose
				//Image img = new Image("imgs/safari3.jpg");
				
				try {

					Parent root = FXMLLoader.load(getClass().getResource("findAllSnackByWorkers.fxml"));
					root.setStyle("-fx-background-image: url('imgs/safari3.jpg');" + "-fx-background-size:cover");
					Scene scene = new Scene(root);
					Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
					window.setScene(scene);
					window.show();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (selected.equals("Get all animals by section max visits")) {
				try {

					Parent root = FXMLLoader.load(getClass().getResource("GetAllAnimalsBySectionMaxVisits.fxml"));
					root.setStyle("-fx-background-image: url('imgs/safari3.jpg');" + "-fx-background-size:cover");
					Scene scene = new Scene(root);
					Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
					window.setScene(scene);
					window.show();
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			else if(selected.equals("All animals by worker")) {
				try {
					Parent root = FXMLLoader.load(getClass().getResource("AllAnimalsByWorkerQuery.fxml"));
					root.setStyle("-fx-background-image: url('imgs/empimg.jpg');"+"-fx-background-size:cover");
					Scene scene = new Scene(root);
					Stage window =  (Stage) ((Node) event.getSource()).getScene().getWindow();
					window.setScene(scene);
					window.show();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			else if(selected.equals("Get all discount amount")) {
				try {
					Parent root = FXMLLoader.load(getClass().getResource("geAllDiscountAmountQuery.fxml"));
					root.setStyle("-fx-background-image: url('imgs/empimg.jpg');"+"-fx-background-size:cover");
					Scene scene = new Scene(root);
					Stage window =  (Stage) ((Node) event.getSource()).getScene().getWindow();
					window.setScene(scene);
					window.show();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			else if(selected.equals("Reptiles sleep at seasson")) {
				try {
					Parent root = FXMLLoader.load(getClass().getResource("reptilesSleepAtSeasonQuery.fxml"));
					root.setStyle("-fx-background-image: url('imgs/empimg.jpg');"+"-fx-background-size:cover");
					Scene scene = new Scene(root);
					Stage window =  (Stage) ((Node) event.getSource()).getScene().getWindow();
					window.setScene(scene);
					window.show();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
			else if(selected.equals("Get max visitors VS max workers")) {
				try {
					Parent root = FXMLLoader.load(getClass().getResource("GetMaxVisitorsVSMaxWorkers.fxml"));
					root.setStyle("-fx-background-image: url('imgs/empimg.jpg');"+"-fx-background-size:cover");
					Scene scene = new Scene(root);
					Stage window =  (Stage) ((Node) event.getSource()).getScene().getWindow();
					window.setScene(scene);
					window.show();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		else
			Alerts.alertBox(AlertType.WARNING, "No Selection detected", "You must select an item", " ");

	}

	public void back(ActionEvent event) {

		if (ControllScenes.getType().equals(Users.ADMIN)) {
			try {

				Parent root = FXMLLoader.load(getClass().getResource("AdminWindow.fxml"));
				root.setStyle("-fx-background-image: url('imgs/zooEmployees.jpg');" + "-fx-background-size:cover");
				Scene scene = new Scene(root);
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(scene);
				window.show();
			} catch (IOException e) {
				Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
			}

		}

		else if (ControllScenes.getType().equals(Users.ZOO_EMPLOYEE)) {
			try {

				Parent root = FXMLLoader.load(getClass().getResource("ZooEmployeeWindow.fxml"));
				root.setStyle("-fx-background-image: url('imgs/empimg.jpg');" + "-fx-background-size:cover");
				Scene scene = new Scene(root);
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(scene);
				window.show();
			} catch (IOException e) {
				Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
			}

		}
	}
}
