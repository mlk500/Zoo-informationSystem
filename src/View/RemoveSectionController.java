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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class RemoveSectionController implements Initializable {
	    @FXML
	    private Button backbtn;

	    @FXML
	    private ComboBox<Section> oldSection;
	    @FXML
	    private ComboBox<Section> newSection;

	  
	    @FXML
	    void remove(ActionEvent event) {
	        Section old=oldSection.getSelectionModel().getSelectedItem();
	        Section New=newSection.getSelectionModel().getSelectedItem();
	        if(oldSection.getSelectionModel().isEmpty()||newSection.getSelectionModel().isEmpty()) {
	        	Alerts.alertBox(AlertType.ERROR, "Invalid", "Invalid Input", "");
	        }
	        else if(!(Zoo.getInstance().removeSection(old, New))) {
	        	Alerts.alertBox(AlertType.ERROR, "Failed", "The remove method has failed", "");
	        }
	        else
				Alerts.alertBox(AlertType.CONFIRMATION, "Success", "The section has been removed succsessfully", "");

	    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Image img = new Image("imgs/back.png", 66, 25, true, false);
		backbtn.setGraphic(new ImageView(img));
		oldSection.getItems().clear();
		oldSection.getItems().addAll(Zoo.getInstance().getSections().values());
		newSection.getItems().clear();
		newSection.getItems().addAll(Zoo.getInstance().getSections().values());
   
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
