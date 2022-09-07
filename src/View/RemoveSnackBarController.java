package View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import Model.SnackBar;
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
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class RemoveSnackBarController implements Initializable {

	@FXML
	private ListView<SnackBar> snackBarList;

	@FXML
	private Button removeBtn;
	@FXML
	private Button backbtn;

	@FXML
	void removeSnackBar(ActionEvent event) {
		SnackBar s = snackBarList.getSelectionModel().getSelectedItem();
		if (snackBarList.getSelectionModel().isEmpty()) {
			Alerts.alertBox(AlertType.ERROR, "Invalid", "Invalid Input", "");
		} else if (!(Zoo.getInstance().removeSnackBar(s))) {
			Alerts.alertBox(AlertType.ERROR, "Failed", "The remove method has failed", "");

		} else {
			Zoo.getInstance().removeSnackBar(snackBarList.getSelectionModel().getSelectedItem());// we remove the
																									// snackBar from our
																									// hashmap
			Alerts.alertBox(AlertType.CONFIRMATION, "Success", "The snack bar has been removed succsessfully", "");

		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {// this function occurs immediately when we open the gui
															// window which means that the item that we removed from the
															// hashmap in the lsat time will not appear here because it
															// will be updated
		snackBarList.getItems().clear();// first we want to clear out combobox and then we add all the items to it
		// we add all of our items back to the list
		snackBarList.getItems().addAll(Zoo.getInstance().getBars().values());
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
				Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
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
				Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
			}
		}
	}

}
