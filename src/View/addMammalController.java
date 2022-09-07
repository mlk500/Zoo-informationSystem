package View;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Model.Bird;
import Model.Mammal;
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

public class addMammalController implements Initializable {

	@FXML
	private TextField Name;

	@FXML
	private DatePicker DOB;

	@FXML
	private ComboBox<AnimalFood> animalFood;

	@FXML
	private ComboBox<Section> section;

	@FXML
	private RadioButton meatEater;

	@FXML
	private ToggleGroup meat;

	@FXML
	private RadioButton noMeat;

	@FXML
	private RadioButton picNotAllowed;

	@FXML
	private ToggleGroup pictureGroupBird;

	@FXML
	private RadioButton picAllowed;

	@FXML
	private Button addBtn;

	@FXML
	private ComboBox<Gender> genderList;
	@FXML
	private Button backbtn;

	@FXML
	void AddMammal(ActionEvent event) {
		boolean meatEaters = meatEater.isSelected() ? true : false;
		boolean noMeats = noMeat.isSelected() ? true : false;
		boolean picAlloweds = picAllowed.isSelected() ? true : false;
		boolean picNotAlloweds = picNotAllowed.isSelected() ? true : false;
		Mammal m = new Mammal(Name.getText(), DOB.getValue(), animalFood.getSelectionModel().getSelectedItem(),
				genderList.getSelectionModel().getSelectedItem(), section.getSelectionModel().getSelectedItem(),
				meatEater.isSelected() ? true : false, picAllowed.isSelected() ? true : false);
		if (Name.getText().isEmpty() || DOB.getValue() == null || animalFood.getSelectionModel().isEmpty()
				|| genderList.getSelectionModel().isEmpty() || (meatEaters == false && noMeats == false)
				|| (picAlloweds == false && picNotAlloweds == false)) {
			Alerts.alertBox(AlertType.INFORMATION, "Failed", "Add Mammal", "The Selected option is invalid");
		} else if (!(Zoo.getInstance().addMammalById(m))) {
			Alerts.alertBox(AlertType.INFORMATION, "Failed", "Add Mamal", "The addMammalById method failed");
		} else
			Zoo.getInstance().addMammalById(m);
		Alerts.alertBox(AlertType.INFORMATION, "Success", "Add Mamal", "The Mammal was Added Successfully");

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		animalFood.getItems().clear();
		animalFood.getItems().addAll(AnimalFood.values());
		section.getItems().clear();
		section.getItems().addAll(Zoo.getInstance().getSections().values());
		genderList.getItems().clear();
		genderList.getItems().addAll(Gender.values());

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
