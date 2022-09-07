package View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Utils.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class RemovesController implements Initializable {
	@FXML
	private Button employeeBtn;
	@FXML
	private Button vistorBtn;
	@FXML
	private Button sbBtn;
	@FXML
	private Button snackBtn;
	@FXML
	private Button mammalBtn;
	@FXML
	private Button birdBtn;
	@FXML
	private Button reptileBtn;
	@FXML
	private Button sectionBtn;
	@FXML
	private Button backbtn;

	public void remove(ActionEvent event) {
		if (event.getSource().equals(employeeBtn)) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("RemoveEmployee.fxml"));
				root.setStyle("-fx-background-image: url('imgs/zooEmployees.jpg');" + "-fx-background-size:cover");
				Scene scene = new Scene(root);
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(scene);
				window.show();
			} catch (IOException e) {
				e.printStackTrace();
				Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
			}
		}

		else if (event.getSource().equals(vistorBtn)) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("RemoveVisitor.fxml"));
				root.setStyle("-fx-background-image: url('imgs/visitors.jpg');" + "-fx-background-size:cover");
				Scene scene = new Scene(root);
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(scene);
				window.show();
			} catch (IOException e) {
				Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
			}
		}

		else if (event.getSource().equals(sbBtn)) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("RemoveSnackBar.fxml"));
				root.setStyle("-fx-background-image: url('imgs/snackBar.jpg');" + "-fx-background-size:cover");
				Scene scene = new Scene(root);
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(scene);
				window.show();
			} catch (IOException e) {
				Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
			}
		}

		else if (event.getSource().equals(snackBtn)) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("RemoveSnack.fxml"));
				root.setStyle("-fx-background-image: url('imgs/snacks.gif');" + "-fx-background-size:cover");
				Scene scene = new Scene(root);
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(scene);
				window.show();
			} catch (IOException e) {
				Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
			}
		} else if (event.getSource().equals(mammalBtn)) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("RemoveMammal.fxml"));
				root.setStyle("-fx-background-image: url('imgs/mammals.jpg');" + "-fx-background-size:cover");
				Scene scene = new Scene(root);
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(scene);
				window.show();
			} catch (IOException e) {
				Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
			}
		} else if (event.getSource().equals(birdBtn)) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("RemoveBird.fxml"));
				root.setStyle("-fx-background-image: url('imgs/birds.jpg');" + "-fx-background-size:cover");
				Scene scene = new Scene(root);
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(scene);
				window.show();
			} catch (IOException e) {
				Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
			}
		} else if (event.getSource().equals(reptileBtn)) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("RemoveReptile.fxml"));
				root.setStyle("-fx-background-image: url('imgs/reptiles.jpg');" + "-fx-background-size:cover");
				Scene scene = new Scene(root);
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(scene);
				window.show();
			} catch (IOException e) {
				Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
			}
		} else if (event.getSource().equals(sectionBtn)) {
			try {

				Parent root = FXMLLoader.load(getClass().getResource("RemoveSection.fxml"));
				root.setStyle("-fx-background-image: url('imgs/sections.jpg');" + "-fx-background-size:cover");
				Scene scene = new Scene(root);
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(scene);
				window.show();
			} catch (IOException e) {
				Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
			}
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

				Parent root = FXMLLoader.load(getClass().getResource("AdminWindow.fxml"));
				root.setStyle("-fx-background-image: url('imgs/safari3.jpg');" + "-fx-background-size:cover");
				Scene adminScene = new Scene(root);
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(adminScene);
				window.show();
			} catch (IOException e) {
				Alerts.alertBox(AlertType.ERROR, "Back", "Could not go back!", "");
			}
		} else {
			try {
				Parent empWindow = FXMLLoader.load(getClass().getResource("ZooEmployeeWindow.fxml"));
				empWindow.setStyle("-fx-background-image: url('imgs/empimg.jpg');" + "-fx-background-size:cover");
				Scene empScene = new Scene(empWindow);
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(empScene);
				window.show();
			} catch (IOException e) {
				Alerts.alertBox(AlertType.ERROR, "Back", "Could not go back!", "");
			}

		}
	}
}
