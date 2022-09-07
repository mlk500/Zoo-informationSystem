package View;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AddSectionController implements Initializable {

	@FXML
	private TextField name;

	@FXML
	private TextField maxCapacitty;

	@FXML
	private Button addBtn;
	@FXML
	private Button backbtn;

	@FXML
	void addSection(ActionEvent event) {
		String Name = name.getText();
		int max;
		try {
			  max = Integer.parseInt(maxCapacitty.getText());//make sure it's integer if not catch the exception and show error label
		} 
		catch (NumberFormatException e) {
			Alerts.alertBox(AlertType.INFORMATION, "INFORMATION", "Enter numbers only!", "");
			
			return;
		}
	
		Section s = new Section(name.getText(), max);
		if (Name == null || maxCapacitty.getText().isEmpty()) {
			Alerts.alertBox(AlertType.INFORMATION, "FAILED", "Add Section", "Invalid input");
		}
		else if (!(Zoo.getInstance().addSection(s))) {
			Alerts.alertBox(AlertType.INFORMATION, "FAILED", "Add Section", "The Add Section Method failed");
		} 
		else {
		Alerts.alertBox(AlertType.INFORMATION, "Success", "Add Section", "The Section was added successfully");
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
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
