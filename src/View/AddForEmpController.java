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

public class AddForEmpController implements Initializable{
	@FXML
	private Button backbtn;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Image img = new Image("imgs/back.png", 66, 25, true, false);
		backbtn.setGraphic(new ImageView(img));
		
	}

    @FXML
    void addEmployee(ActionEvent event) throws Exception {
    	Parent root = FXMLLoader.load(getClass().getResource("AddNewZooEmployee.fxml"));
		root.setStyle("-fx-background-image: url('imgs/zooEmployees.jpg');"+"-fx-background-size:cover");
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
    }

    @FXML
    void addSnack(ActionEvent event) throws Exception{
    	Parent root = FXMLLoader.load(getClass().getResource("AddSnack.fxml"));
		root.setStyle("-fx-background-image: url('imgs/snacks.gif');"+"-fx-background-size:cover");
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
    }

    @FXML
    void addVisitor(ActionEvent event)throws Exception {
    	Parent root = FXMLLoader.load(getClass().getResource("AddVisitor.fxml"));
		root.setStyle("-fx-background-image: url('imgs/visitors.jpg');"+"-fx-background-size:cover");
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
    }
    
    public void back(ActionEvent event) {
		if(ControllScenes.getType().equals(Users.ZOO_EMPLOYEE)) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("ZooEmployeeWindow.fxml"));
    		root.setStyle("-fx-background-image: url('imgs/empimg.jpg');"+"-fx-background-size:cover");
    		Scene adminScene = new Scene(root);
    		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		window.setScene(adminScene);
    		window.show();
		} catch (IOException e) {
			Alerts.alertBox(AlertType.ERROR, "Back", "Could not go back!", "");
		}
		}
    }
		
    
    

}
