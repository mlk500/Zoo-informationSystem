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

public class GetsController implements Initializable {
	@FXML
	private Button empBtn;
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
	private Button back;
	
	public void getObjects(ActionEvent event) throws IOException {
		if(event.getSource().equals(empBtn)) {
			Parent root = FXMLLoader.load(getClass().getResource("getEmployee.fxml"));
			root.setStyle("-fx-background-image: url('imgs/zooEmployees.jpg');"+"-fx-background-size:cover");
			Scene scene = new Scene(root);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		}
		
		else if(event.getSource().equals(vistorBtn)) {
			Parent root = FXMLLoader.load(getClass().getResource("getVisitor.fxml"));
			root.setStyle("-fx-background-image: url('imgs/visitors.jpg');"+"-fx-background-size:cover");
			Scene scene = new Scene(root);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		}
	
		else if(event.getSource().equals(sbBtn)) {
			Parent root = FXMLLoader.load(getClass().getResource("getSnackBar.fxml"));
			root.setStyle("-fx-background-image: url('imgs/snackBar.jpg');"+"-fx-background-size:cover");
			Scene scene = new Scene(root);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		}
		
		else if(event.getSource().equals(snackBtn)) {
			Parent root = FXMLLoader.load(getClass().getResource("getSnack.fxml"));
			root.setStyle("-fx-background-image: url('imgs/snacks.gif');"+"-fx-background-size:cover");
			Scene scene = new Scene(root);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		}
		else if(event.getSource().equals(mammalBtn)) {
			Parent root = FXMLLoader.load(getClass().getResource("getMammal.fxml"));
			root.setStyle("-fx-background-image: url('imgs/mammals.jpg');"+"-fx-background-size:cover");
			Scene scene = new Scene(root);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		}
		else if(event.getSource().equals(birdBtn)) {
			Parent root = FXMLLoader.load(getClass().getResource("getBird.fxml"));
			root.setStyle("-fx-background-image: url('imgs/birds.jpg');"+"-fx-background-size:cover");
			Scene scene = new Scene(root);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		}
		else if(event.getSource().equals(reptileBtn)) {
			Parent root = FXMLLoader.load(getClass().getResource("getReptile.fxml"));
			root.setStyle("-fx-background-image: url('imgs/reptiles.jpg');"+"-fx-background-size:cover");
			Scene scene = new Scene(root);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		}
		else if(event.getSource().equals(sectionBtn)) {
			Parent root = FXMLLoader.load(getClass().getResource("getSection.fxml"));
			root.setStyle("-fx-background-image: url('imgs/sections.jpg');"+"-fx-background-size:cover");
			Scene scene = new Scene(root);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		}	
	}
	public void back(ActionEvent event) {
		if(ControllScenes.getType().equals(Users.ADMIN)) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("AdminWindow.fxml"));
    		root.setStyle("-fx-background-image: url('imgs/safari3.jpg');"+"-fx-background-size:cover");
    		Scene adminScene = new Scene(root);
    		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		window.setScene(adminScene);
    		window.show();
		} catch (IOException e) {
			Alerts.alertBox(AlertType.ERROR, "Back", "Could not go back!", "");
		}
		}
		else if (ControllScenes.getType().equals(Users.ZOO_EMPLOYEE)) {
			try {

				Parent root = FXMLLoader.load(getClass().getResource("ZooEmployeeWindow.fxml"));
				root.setStyle("-fx-background-image: url('imgs/empimg.jpg');" + "-fx-background-size:cover");
				Scene scene = new Scene(root);
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(scene);
				window.show();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		

	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Image img = new Image("imgs/back.png", 66, 25, true, false);
		back.setGraphic(new ImageView(img));
		
	}

}
