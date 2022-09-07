package View;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Model.Bird;
import Model.Reptile;
import Model.Section;
import Model.Zoo;
import Utils.AnimalFood;
import Utils.Gender;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AddReptileController implements Initializable {

	@FXML
	private TextField Name;

	@FXML
	private DatePicker DOB;

	@FXML
	private ComboBox<AnimalFood> animalFood;

	@FXML
	private ComboBox<Gender> gender;

	@FXML
	private ComboBox<Section> section;

	@FXML
	private RadioButton isDangerous;

	@FXML
	private ToggleGroup dangerousGroup;

	@FXML
	private RadioButton isNotDangerous;

	@FXML
	private RadioButton doesNotSleep;

	@FXML
	private ToggleGroup sleepGroup;

	@FXML
	private RadioButton doesSleep;

	@FXML
	private Button addBtn;
	@FXML
	private Button backbtn;

	@FXML
	void AddReptile(ActionEvent event) {
		boolean IsDangerous = isDangerous.isSelected() ? true : false;
		boolean IsNotDangerous = isNotDangerous.isSelected() ? true : false;
		boolean DoesSleep = doesSleep.isSelected() ? true : false;
		boolean DoesNotSleep = doesNotSleep.isSelected() ? true : false;
		Reptile r = new Reptile(Name.getText(), DOB.getValue(), animalFood.getSelectionModel().getSelectedItem(),
				gender.getSelectionModel().getSelectedItem(), section.getSelectionModel().getSelectedItem(),
				isDangerous.isSelected() ? true : false, doesSleep.isSelected() ? true : false);

		if (Name.getText().isEmpty() || DOB.getValue() == null || animalFood.getSelectionModel().isEmpty()
				|| gender.getSelectionModel().isEmpty() || (IsDangerous == false && IsNotDangerous == false)
				|| (DoesSleep == false && DoesNotSleep == false)) {
			Alerts.alertBox(AlertType.ERROR, "Failed", "Add Reptile", "The Selected option is invalid");
		} else if (!(Zoo.getInstance().addReptileById(r))) {
			Alerts.alertBox(AlertType.ERROR, "Failed", "Add Reptile", "The addReptileById method failed");
		} else
			Zoo.getInstance().addReptileById(r);
		Alerts.alertBox(AlertType.CONFIRMATION, "Success", "Add Mamal", "The Mammal was Added Successfully");

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		animalFood.getItems().clear();
		animalFood.getItems().addAll(AnimalFood.values());
		section.getItems().clear();
		section.getItems().addAll(Zoo.getInstance().getSections().values());
		gender.getItems().clear();
		gender.getItems().addAll(Gender.values());
		Image img = new Image("imgs/back.png", 66, 25, true, false);
		backbtn.setGraphic(new ImageView(img));

		DOB.setDayCellFactory(d -> new DateCell() {// in here we set the max date to be today which means that the user
													// can't say an animal was born tommowrow
			@Override
			public void updateItem(LocalDate item, boolean empty) {
				super.updateItem(item, empty);
				setDisable(item.isAfter(LocalDate.now()));
			}
		});

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
