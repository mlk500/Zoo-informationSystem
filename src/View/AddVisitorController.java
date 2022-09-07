package View;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Model.Section;
import Model.Visitor;
import Model.Zoo;

import Utils.Discount;
import Utils.Gender;
import Utils.TicketType;
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

import javafx.scene.control.TextField;

import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AddVisitorController implements Initializable {

	@FXML
	private TextField firstName;

	@FXML
	private TextField lastName;

	@FXML
	private DatePicker DOB;
	@FXML
	private ComboBox<Gender> gender;
	@FXML
	private ComboBox<Section> sectionList;

	@FXML
	private ComboBox<TicketType> ticketType;

	@FXML
	private ComboBox<Discount> discount;

	@FXML
	private Button addBtn;
	@FXML
	private Button backbtn;

	@FXML
	void addVisitor(ActionEvent event) {
		Visitor v = new Visitor(firstName.getText(), lastName.getText(), DOB.getValue(),
				gender.getSelectionModel().getSelectedItem(), ticketType.getSelectionModel().getSelectedItem(),
				discount.getSelectionModel().getSelectedItem());
		if (firstName.getText().isEmpty() || lastName.getText().isEmpty() || DOB.getValue() == null
				|| gender.getSelectionModel().isEmpty() || ticketType.getSelectionModel().isEmpty()
				|| discount.getSelectionModel().isEmpty()||sectionList.getSelectionModel().isEmpty()) {
			Alerts.alertBox(AlertType.INFORMATION, "Failed", "Add Visitor", "Invalid input");
		} else if (!(Zoo.getInstance().newVisitorInZoo(v, sectionList.getSelectionModel().getSelectedItem()))) {
			Alerts.alertBox(AlertType.INFORMATION, "Failed", "Add Visitor", "The Add Visitor method has Failed");

		} else
			Zoo.getInstance().addVisitor(v);
		Alerts.alertBox(AlertType.INFORMATION, "Success", "Add Visitor", "The Visitor has been added successfully");

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		gender.getItems().clear();
		gender.getItems().addAll(Gender.values());
		ticketType.getItems().clear();
		ticketType.getItems().addAll(TicketType.values());
		discount.getItems().clear();
		discount.getItems().addAll(Discount.values());
		Image img = new Image("imgs/back.png", 66, 25, true, false);
		backbtn.setGraphic(new ImageView(img));
		sectionList.getItems().clear();
		sectionList.getItems().addAll(Zoo.getInstance().getSections().values());
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
