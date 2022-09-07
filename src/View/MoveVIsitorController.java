package View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import Model.Section;
import Model.Visitor;
import Model.Zoo;

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

public class MoveVIsitorController implements Initializable {

	@FXML
	private ComboBox<Visitor> visitorList;

	@FXML
	private ComboBox<Section> sectionList;
	@FXML
	private Button backbtn;

	@FXML
	void move(ActionEvent event) {
		Visitor v = visitorList.getSelectionModel().getSelectedItem();
		
		Section s = sectionList.getSelectionModel().getSelectedItem();
		
		if (v == null || s == null) {//make sure they are valid
			Alerts.alertBox(AlertType.INFORMATION, "Failed", "Move Visitor", "The Selected option is invalid");
		}
		
		
			else if ((v.getSection().getMaxCapacity() / 2) >= v.getSection().getVisitors().size() - 1) {//check if we can move the visitor
			System.out.println(v.getSection().getMaxCapacity() + ", " + (v.getSection().getVisitors().size() - 1));
			Alerts.alertBox(AlertType.INFORMATION, "Failed", "Move Visitor",
					"The section has reached to less than 50% of its capacity, you can't move to another section");
		}  else {
			v.moveVisitorToSection(s);
			Alerts.alertBox(AlertType.INFORMATION, "Success", "Move visitor", "Visitor has been moved successfully");

		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		visitorList.getItems().clear();
		visitorList.getItems().addAll(Zoo.getInstance().getVisitors().values());
		sectionList.getItems().clear();
		sectionList.getItems().addAll(Zoo.getInstance().getSections().values());
		Image img = new Image("imgs/back.png", 66, 25, true, false);
		backbtn.setGraphic(new ImageView(img));
	}

	public void back(ActionEvent event) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("VisitorActions.fxml"));
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
