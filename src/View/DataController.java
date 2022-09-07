package View;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import Model.*;
import Utils.Users;

public class DataController implements Initializable{
	@FXML
	private Button backbtn;
	@FXML
	private ComboBox<String> cmbx;//to choose what we want to get zoo employee visitors...
	@FXML
	private Button getBtn;
	@FXML
	private ListView<String> resultList;// print the result in it
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {//initialize
		Image img = new Image("imgs/back.png", 66, 25, true, false);
		backbtn.setGraphic(new ImageView(img));
		cmbx.getItems().add("Zoo Employees");
		cmbx.getItems().add("Visitors");
		cmbx.getItems().add("Mammals");
		cmbx.getItems().add("Birds");
		cmbx.getItems().add("Reptiles");
		cmbx.getItems().add("Snacks");
		cmbx.getItems().add("Snack Bars");
		cmbx.getItems().add("Sections");
		cmbx.getItems().add("Animals Treated By ZooEmployee");
		cmbx.getItems().add("Animals Visits By People");
	}
	
	public void get(ActionEvent event) {//the get button when pressed we want to get the information
		resultList.getItems().clear();
		if(cmbx.getSelectionModel().getSelectedItem().equals("Zoo Employees")) {//check if the user choosed zooemploye return all the infor for employees
			for(ZooEmployee i : Zoo.getInstance().getEmployees().values()) {
				if(i != null) {
					resultList.getItems().add(i.toString());
				}
			}
		}
		
		else if(cmbx.getSelectionModel().getSelectedItem().equals("Visitors")){//check if the user choose visitors return all the visitors information in the list view
			for(Visitor i : Zoo.getInstance().getVisitors().values()) {
				if(i != null) {
					resultList.getItems().add(i.toString());
				}
			}
		}
		else if(cmbx.getSelectionModel().getSelectedItem().equals("Mammals")){
			for(Mammal i : Zoo.getInstance().getMammals().values()) {
				if(i != null) {
					resultList.getItems().add(i.toString());
				}
			}
		}

		else if(cmbx.getSelectionModel().getSelectedItem().equals("Birds")){
			for(Bird i : Zoo.getInstance().getBirds().values()) {
				if(i != null) {
					resultList.getItems().add(i.toString());
				}
			}
		}
		else if(cmbx.getSelectionModel().getSelectedItem().equals("Reptiles")){
			for(Reptile i : Zoo.getInstance().getReptiles().values()) {
				if(i != null) {
					resultList.getItems().add(i.toString());
				}
			}
		}
		
		else if(cmbx.getSelectionModel().getSelectedItem().equals("Snacks")){
			for(Snack i : Zoo.getInstance().getSnacks().values()) {
				if(i != null) {
					resultList.getItems().add(i.toString());
				}
			}
		}
	
		else if(cmbx.getSelectionModel().getSelectedItem().equals("Snack Bars")){
			for(SnackBar i : Zoo.getInstance().getBars().values()) {
				if(i != null) {
					resultList.getItems().add(i.toString());
				}
			}
		}
	
		else if(cmbx.getSelectionModel().getSelectedItem().equals("Sections")){
			for(Section i : Zoo.getInstance().getSections().values()) {
				if(i != null) {
					resultList.getItems().add(i.toString());
				}
			}
		}
		else if(cmbx.getSelectionModel().getSelectedItem().equals("Animals Treated By ZooEmployee")){
			HashMap<ZooEmployee, HashSet<Animal>> map = Zoo.getInstance().getAnimalTreatedByZooEmployee();
			for(Map.Entry<ZooEmployee, HashSet<Animal>> i : Zoo.getInstance().getAnimalTreatedByZooEmployee().entrySet()) {
				if(i != null) {
					resultList.getItems().add(i.toString() + " ");
				
				for(Animal a : i.getValue()) {
					if(a != null) {
						resultList.getItems().add(a.toString());
					}
				}
			}
		}
			resultList.getItems().add("\n");
		}
		
		else if(cmbx.getSelectionModel().getSelectedItem().equals("Animals Visits By People")) {
			HashMap<Visitor, HashSet<Animal>> map = Zoo.getInstance().getAnimalVisitsByPeople();
			for(Map.Entry<Visitor, HashSet<Animal>> i : Zoo.getInstance().getAnimalVisitsByPeople().entrySet()) {
				if(i != null) {
					resultList.getItems().add(i.toString() + " " +i.getValue().toString());
					for(Animal a : i.getValue()) {
						if(a != null) {
							resultList.getItems().add(a.toString());
						}
				}
			}
				resultList.getItems().add("\n");
				}
			}
		
		else
			Alerts.alertBox(AlertType.WARNING, "No Selection detected", "You must select an item", " ");//if he didn't choose anything
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
				e.printStackTrace();
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
				e.printStackTrace();
			}

		}
	}

}
