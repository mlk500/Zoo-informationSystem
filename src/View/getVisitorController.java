package View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javafx.scene.control.ListView;

public class getVisitorController implements Initializable {
	@FXML
	private TextField txtEmp;

	@FXML
	private Button btnGet;
	@FXML
	private Button backbtn;
	@FXML
	private ListView<Visitor> resultList;

	public void get(ActionEvent event) {
		resultList.getItems().clear();
		String msg = txtEmp.getText();
		int num = 0;
		try {
			num = Integer.parseInt(msg);//convert to int make sure it's valid
		} catch (NumberFormatException e) {
			Alerts.alertBox(AlertType.ERROR, "ERROR", "Enter numbers only!", "");//catch the exception and throw an error message
			return;
		}
		if (Zoo.getInstance().getRealVisitor(num) != null) {
			resultList.getItems().add(Zoo.getInstance().getRealVisitor(num));//find the visitor by it's id and display it in the list view
		} else
			Alerts.alertBox(AlertType.INFORMATION, "Not Found", "Not Found", "");
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
