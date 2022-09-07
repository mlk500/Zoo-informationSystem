package View;

import java.io.IOException;

import Model.Zoo;
import Utils.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LoginController {
	@FXML
	private Label lbl;
	@FXML
	private TextField userid;
	@FXML
	private PasswordField passid;
	static Users t;

	public void login(ActionEvent event) throws IOException {

		String username = userid.getText();
		String password = passid.getText();

		if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
			// show error message
			Alerts.alertBox(AlertType.ERROR, "Failed", "Invalid input", "Please try again");

		}

		else if (username.equals("Admin") && password.equals("Admin")) {
			// show Admin's fxml file
			try {
				Parent root = FXMLLoader.load(getClass().getResource("AdminWindow.fxml"));
				root.setStyle("-fx-background-image: url('imgs/safari3.jpg');" + "-fx-background-size:cover");
				Scene adminScene = new Scene(root);
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(adminScene);
				window.show();

			} catch (IOException e) {
				// failed to load employee window
				Alerts.alertBox(AlertType.ERROR, "Failed", "Could not load file!", "Please try again");
			}

			t = Users.ADMIN;
			ControllScenes.setType(t);
			// System.out.println("show Admin's fxml file");
		}

		else if (Zoo.getInstance().isSystemUserExist(username, password)) {//check if username and password exist
			try {
				Parent empWindow = FXMLLoader.load(getClass().getResource("ZooEmployeeWindow.fxml"));
				empWindow.setStyle("-fx-background-image: url('imgs/empimg.jpg');" + "-fx-background-size:cover");
				Scene empScene = new Scene(empWindow);
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(empScene);
				window.show();
				t = Users.ZOO_EMPLOYEE;
				ControllScenes.setType(t);
				ControllScenes.setZooEmployee((Zoo.getInstance().getSystemUser(username, password)));
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("failed to load employee window");
			}
			// a catch or an else cond that the user does not exist
		} else// username or password are wrong
		{
			Alerts.alertBox(AlertType.ERROR, "Failed to log in",
					"You either not registered as a user or you entered a wrong username/passwoord", " ");

		}
	}

}
