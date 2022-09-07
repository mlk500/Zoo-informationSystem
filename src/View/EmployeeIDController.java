package View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.Zoo;
import Model.ZooEmployee;
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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class EmployeeIDController implements Initializable {

    @FXML
    private ComboBox<ZooEmployee> employee;

    @FXML
    private TextField user;

    @FXML
    private TextField pass;
    @FXML
	private Button backbtn;
//in this class we want to change the employee user name and password only valid for admin
    @FXML
    void change(ActionEvent event) {
    	String userName=user.getText();
    	String Password=pass.getText();
    	ZooEmployee z=	employee.getSelectionModel().getSelectedItem();
    	if(userName.isEmpty()||Password.isEmpty()||employee.getSelectionModel().isEmpty()) {
			Alerts.alertBox(AlertType.ERROR, "Failed", "Invalid input", "Please try again");//check the input
    	}
    	else {
    		for(ZooEmployee e:Zoo.getInstance().getEmployees().values()) {//check which employee was chosen
    			if(e.getUsername().equals(userName)) {//make sure no body else uses this username
    				Alerts.alertBox(AlertType.ERROR, "Failed", "Invalid input", "The username alredy exists!");
    				return;
    			}
    		}
    		z.setUsername(userName);//update the user name and password
    		z.setPassword(Password);
			Alerts.alertBox(AlertType.CONFIRMATION, "Success", "Success", "The username was changed Successfully!");

    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	employee.getItems().clear();
	employee.getItems().addAll(Zoo.getInstance().getEmployees().values());
	Image img = new Image("imgs/back.png", 66, 25, true, false);
	backbtn.setGraphic(new ImageView(img));
		
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

}
}
