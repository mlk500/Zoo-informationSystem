package View;
/**
 *ALL OF THE DESCRIPTION FOR THE REMOVE CONTROLS IS IN THE REMOVE BIRD CONTROLLER
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.Bird;
import Model.Zoo;
import Model.ZooEmployee;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class RemoveBirdController implements Initializable {

	@FXML
	private ComboBox<Bird> birdList;

	@FXML
	private Button removeBtn;
	@FXML
	private Button backbtn;

	@FXML
	void removeBird(ActionEvent event) {
		Bird b = birdList.getSelectionModel().getSelectedItem();//get the selection
		if (birdList.getSelectionModel().isEmpty()) {// make sure that that it's not empty the user selected something
			Alerts.alertBox(AlertType.INFORMATION, "Invalid", "Invalid Input", "");
		} else if (!(Zoo.getInstance().removeBird(b))) {//call the remove method and check if it returns false to send a pop up message
			Alerts.alertBox(AlertType.INFORMATION, "Failed", "The  method has failed", "");

		} else {
			Zoo.getInstance().removeBird(birdList.getSelectionModel().getSelectedItem());// we remove the bird from our
																							// hash map
			Alerts.alertBox(AlertType.INFORMATION, "Success", "The Bird has been removed succsessfully", "");
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {// this function occurs immediately when we open the gui
															// window which means that the item that we removed from the
															// hashmap in the last time will not appear here because it
															// will be updated
		birdList.getItems().clear();// first we want to clear out combobox and then we add all the items to it
		// we add all of our items back to the list
		birdList.getItems().addAll(Zoo.getInstance().getBirds().values());//ADD THEM ALL TO THE LIST
		Image img = new Image("imgs/back.png", 66, 25, true, false);
		backbtn.setGraphic(new ImageView(img));
	}

	public void back(ActionEvent event) {
		if (ControllScenes.getType().equals(Users.ADMIN)) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("Removes.fxml"));
				root.setStyle("-fx-background-image: url('imgs/safari3.jpg');" + "-fx-background-size:cover");
				Scene scene = new Scene(root);
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(scene);
				window.show();
			} catch (IOException e) {
				Alerts.alertBox(AlertType.INFORMATION, "File Loading", "Coud not load file!", " ");
			}
		} else {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("RemoveForEmp.fxml"));
				root.setStyle("-fx-background-image: url('imgs/safari3.jpg');" + "-fx-background-size:cover");
				Scene scene = new Scene(root);
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(scene);
				window.show();
			} catch (IOException e) {
				Alerts.alertBox(AlertType.INFORMATION, "File Loading", "Coud not load file!", " ");
			}
		}
	}
}
