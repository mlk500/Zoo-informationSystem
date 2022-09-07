//all of the adds description is in the AddBird controller

package View;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Model.Bird;
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

public class AddBirdController implements Initializable {

	private static final String True = null;

	private static final String False = null;

	private static final Gender Male = null;

	private static final Gender Female = null;

	@FXML
	private TextField Name;

	@FXML
	private DatePicker DOB;

	@FXML
	private ComboBox<AnimalFood> animalFood;

	@FXML
	private ComboBox<Section> section;

	@FXML
	private RadioButton canFly;

	@FXML
	private ToggleGroup flyGroup;

	@FXML
	private RadioButton cannotFly;

	@FXML
	private RadioButton picNotAllowed;

	@FXML
	private ToggleGroup pictureGroupBird;

	@FXML
	private RadioButton picAllowed;
	@FXML
	private Button addBtn;
	@FXML
	private Button backbtn;

	@FXML
	private ComboBox<Gender> genderList;

	@FXML
	void AddBird(ActionEvent event) {
		boolean canFlyS = canFly.isSelected() ? true : false;//boolean objects to check
		boolean cannotFlys = cannotFly.isSelected() ? true : false;
		boolean picAlloweds = picAllowed.isSelected() ? true : false;
		boolean picNotAlloweds = picNotAllowed.isSelected() ? true : false;

		if (Name.getText().isEmpty() || DOB.getValue() == null || animalFood.getSelectionModel().isEmpty()
				|| genderList.getSelectionModel().isEmpty() || (canFlyS == false & cannotFlys == false)
				|| (picAlloweds == false && picNotAlloweds == false)) {//we wanna make sure all of the input is legal if not then we send a pop up message
			Alerts.alertBox(AlertType.ERROR, "Failed", "Add Bird", "The Selected option is invalid");
		}
		Bird b = new Bird(Name.getText(), DOB.getValue(), animalFood.getSelectionModel().getSelectedItem(),//create a new object from the user and save it
				genderList.getSelectionModel().getSelectedItem(), section.getSelectionModel().getSelectedItem(),
				canFly.isSelected() ? true : false, picAllowed.isSelected() ? true : false);
		if (!(Zoo.getInstance().addBirdById(b))) {//check if the add method succeeds
			Alerts.alertBox(AlertType.ERROR, "Failed", "Add Bird", "The addBirdById method failed");
		} else
			Zoo.getInstance().addBirdById(b);
		Alerts.alertBox(AlertType.CONFIRMATION, "Success", "Add Bird", "The Bird was Added Successfully");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {//initialize basically runs in the window before we do anything so we want every time we open the add window to update all of the combo box
		animalFood.getItems().clear();//clear them
		animalFood.getItems().addAll(AnimalFood.values());//then add all of the values back
		section.getItems().clear();
		section.getItems().addAll(Zoo.getInstance().getSections().values());
		genderList.getItems().clear();
		genderList.getItems().addAll(Gender.values());

		Image img = new Image("imgs/back.png", 66, 25, true, false);//back button icon
		backbtn.setGraphic(new ImageView(img));//setting the icon

		DOB.setDayCellFactory(d -> new DateCell() {// in here we set the max date to be today which means that the user
													// can't say an animal was born tommowrow
			@Override
			public void updateItem(LocalDate item, boolean empty) {
				super.updateItem(item, empty);
				setDisable(item.isAfter(LocalDate.now()));
			}
		});
	}

	public void back(ActionEvent event) {//back button checks where is the window that we wanna be taken to
		if (ControllScenes.getType().equals(Users.ADMIN)) {//check if it's admin or employee so we would know where to go to which main screen
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
