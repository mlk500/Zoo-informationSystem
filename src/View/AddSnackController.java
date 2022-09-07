



package View;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Model.Snack;
import Model.SnackBar;
import Model.Zoo;
import Utils.AnimalFood;
import Utils.Gender;
import Utils.SnackType;
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
import javafx.scene.control.DateCell;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AddSnackController implements Initializable {

	@FXML
	private ComboBox<SnackType> snackType;

	@FXML
	private TextField snackName;

	@FXML
	private ListView<SnackBar> snackBar;

	@FXML
	private TextField price;

	@FXML
	private RadioButton yesBtn;

	@FXML
	private ToggleGroup fatGroup;

	@FXML
	private RadioButton noBtn;
	@FXML
	private Button backbtn;

	
	@FXML
	void addSnack(ActionEvent event) {
		boolean YesBtn = yesBtn.isSelected() ? true : false;
		boolean NoBtn = noBtn.isSelected() ? true : false;
		double cost = 0;
		try {
			cost = Double.parseDouble(price.getText());//make sure it's double
		} catch (NumberFormatException e) {
			Alerts.alertBox(AlertType.ERROR, "ERROR", "Enter numbers only!", "");
			return;
		}
		Snack s = new Snack(snackType.getSelectionModel().getSelectedItem(), snackName.getText(),
				snackBar.getSelectionModel().getSelectedItem(), yesBtn.isSelected() ? true : false, cost);
		if (snackType.getSelectionModel().isEmpty() || snackName.getText().isEmpty()
				|| snackBar.getSelectionModel().isEmpty() || price.getText().isEmpty()
				|| (YesBtn == false && NoBtn == false)) {
			Alerts.alertBox(AlertType.ERROR, "Failed", "Add Snack", "Invalid input");

		} else if (!(Zoo.getInstance().addSnack(s))) {
			Alerts.alertBox(AlertType.ERROR, "Failed", "Add Snack", "The Add Snack method has Failed");
		} else
			Zoo.getInstance().addSnack(s);
		Alerts.alertBox(AlertType.CONFIRMATION, "Success", "Add Snack", "The Snack has been added successfully");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		snackType.getItems().clear();
		snackType.getItems().addAll(SnackType.values());
		snackBar.getItems().clear();
		snackBar.getItems().addAll(Zoo.getInstance().getBars().values());
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
				Alerts.alertBox(AlertType.ERROR, "Back", "Could not go back!", "");
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
				Alerts.alertBox(AlertType.ERROR, "Back", "Could not go back!", "");
			}

		}
	}
}
