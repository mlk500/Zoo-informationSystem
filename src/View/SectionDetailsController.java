package View;

import java.io.IOException;
import java.net.URL;

import java.util.HashMap;

import java.util.ResourceBundle;

import Model.Section;
import Model.Zoo;
import Utils.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class SectionDetailsController implements Initializable {
	@FXML
	private Button backbtn, getBtn;
	@FXML
	private ComboBox<Section> cmbx;
	@FXML
	private ListView<String> resultList;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Image img = new Image("imgs/back.png", 66, 25, true, false);
		backbtn.setGraphic(new ImageView(img));

		HashMap<Integer, Section> a = Zoo.getInstance().getSections();//get all the sections in the hashmap
		if (a == null || a.isEmpty()) {//make sure the map is valid
			if (a.isEmpty() || a == null) {
				Alerts.alertBox(AlertType.INFORMATION, "Get Section Details", "No results found!", "");
			}
		}
		for (Section i : a.values()) {//add all of the sections into the section combo box
			if (i != null) {
				cmbx.getItems().add(i);
			}
		}

	}

	public void get(ActionEvent event) {
		resultList.getItems().clear();//the user will choose a section
		Section s = cmbx.getSelectionModel().getSelectedItem();//make sure that the selection is valid
		if (s != null) {//not null
			String text = Zoo.getInstance().getSections().get(s.getId()).getSectionDetails();
			resultList.getItems().add(text);//add the returned string to the list to displayit
		} else {
			Alerts.alertBox(AlertType.WARNING, "No Selection detected", "You must select an item", " ");
		}
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
				root.setStyle("-fx-background-image: url('imgs/zooEmployees.jpg');" + "-fx-background-size:cover");
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
