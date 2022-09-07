package View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.Zoo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.stage.Stage;

import javafx.scene.control.ListView;


public class getBirdController implements Initializable {
	@FXML
	private TextField txtEmp;//enter the id
	@FXML
	private Button backbtn;
	@FXML
	private ListView<String> resultList;
	@FXML
	private Button btnGet;

	public void get(ActionEvent event) {
		resultList.getItems().clear();
		String msg = txtEmp.getText();//convert to int make sure it's valid
		int num = 0;
		try {
			num = Integer.parseInt(msg);
		} catch (NumberFormatException e) {
			 Alerts.alertBox(AlertType.ERROR,"ERROR","Enter numbers only!", "" );
			return;
		}
		if (Zoo.getInstance().getRealBird(num) != null) {//return the bird
			resultList.getItems().add(Zoo.getInstance().getRealBird(num).toString());

		} else
			Alerts.alertBox(AlertType.INFORMATION,"Not Found","Not Found", "" );
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		Image img = new Image("imgs/back.png", 66, 25, true, false);
		backbtn.setGraphic(new ImageView(img));

	}

	public void back(ActionEvent event) {

		try {

			Parent root = FXMLLoader.load(getClass().getResource("Gets.fxml"));
			root.setStyle("-fx-background-image: url('imgs/empimg.jpg');" + "-fx-background-size:cover");
			Scene empScene = new Scene(root);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(empScene);
			window.show();
			root.setStyle("-fx-background-image: url('imgs/empimg.jpg');" + "-fx-background-size:cover");
		} catch (IOException e) {
			Alerts.alertBox(AlertType.ERROR, "Back", "Could not go back!", "");
		}

	}

}
