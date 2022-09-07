package View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.Section;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AddSnackBarController implements Initializable {

	@FXML
	private TextField name;

	@FXML
	private ComboBox<Section> section;
	@FXML
	private Button backbtn;

	@FXML
	void addSnacBar(ActionEvent event) {
		if (name.getText().isEmpty() || section.getSelectionModel().isEmpty()) {
			Alerts.alertBox(AlertType.INFORMATION, "Failed", "Add SnackBar", "Invalid input");
		} else if (!(Zoo.getInstance().addSnackBar(new SnackBar(name.getText(), section.getSelectionModel().getSelectedItem()),
				section.getSelectionModel().getSelectedItem()))) {
			Alerts.alertBox(AlertType.INFORMATION, "Failed", "Add SnackBar", "The addSnackBar method has Failed");
		} else {
			Zoo.getInstance().addSnackBar(new SnackBar(name.getText(), section.getSelectionModel().getSelectedItem()),
					section.getSelectionModel().getSelectedItem());
		Alerts.alertBox(AlertType.INFORMATION, "Success", "Add SnackBar", "The Snack Bar has been added successfully");
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		section.getItems().clear();
		section.getItems().addAll(Zoo.getInstance().getSections().values());
		Image img = new Image("imgs/back.png", 66, 25, true, false);
		backbtn.setGraphic(new ImageView(img));
	}

	public void back(ActionEvent event) {
		if (ControllScenes.getType().equals(Users.ADMIN)) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("Adds.fxml"));
				root.setStyle("-fx-background-image: url('imgs/safari3.jpg');" + "-fx-background-size:cover");
				Scene scene = new Scene(root);
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(scene);
				window.show();
			}

			catch (IOException e) {
				Alerts.alertBox(AlertType.INFORMATION, "Back", "Could not go back!", "");
			}

		} else {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("AddForEmp.fxml"));
				root.setStyle("-fx-background-image: url('imgs/safari3.jpg');" + "-fx-background-size:cover");
				Scene scene = new Scene(root);
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(scene);
				window.show();
			}

			catch (IOException e) {
				Alerts.alertBox(AlertType.INFORMATION, "Back", "Could not go back!", "");
			}

		}
	}
}
