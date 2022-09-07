package View;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import Model.Snack;
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
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class PurchaseSnackController implements Initializable {
	@FXML
	private Button backbtn, getBtn;
	@FXML
	private ComboBox<Visitor> cbV;
	@FXML
	private ComboBox<Snack> cbS;
	@FXML
	ListView<String> listView;

	@Override

	public void initialize(URL arg0, ResourceBundle arg1) {
		Image img = new Image("imgs/back.png", 66, 25, true, false);
		backbtn.setGraphic(new ImageView(img));
		HashMap<Integer, Visitor> m = Zoo.getInstance().getVisitors();//hashmap
		if (m == null || m.isEmpty()) {//make sure they are not null
			Alerts.alertBox(AlertType.INFORMATION, "Not Found", "No Results Found!", " ");
			return;
		} else {
			for (Visitor i : m.values()) {//show all the visitors
				if (i != null) {
					cbV.getItems().add(i);
				}
			}

			HashMap<Integer, Snack> map = Zoo.getInstance().getSnacks();
//show all the snacks
			if (map == null || map.isEmpty()) {
				Alerts.alertBox(AlertType.INFORMATION, "Not Found", "No Results Found!", " ");
				return;
			} else {
				for (Snack i : map.values()) {
					if (i != null) {
						cbS.getItems().add(i);
					}
				}
			}
		}
	}

	public void get(ActionEvent event) {//get
		listView.getItems().clear();//clear so we would add the new input
		Snack s = cbS.getSelectionModel().getSelectedItem();
		Visitor v = cbV.getSelectionModel().getSelectedItem();
		if (s != null && v != null) {//make sure the selection is valid
			String result = Zoo.getInstance().getVisitors().get(v.getId()).purchaseSnack(s);//get the returned value from the purchase sanck method
			
			listView.getItems().add(result);//add it to the list view
		} else {
			Alerts.alertBox(AlertType.WARNING, "No Selection detected", "You must select an item", " ");//error message
		}
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
			Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");

		}
	}
}
