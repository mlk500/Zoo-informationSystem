package View;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeMap;

import Model.SnackBar;
import Model.Visitor;
import Model.Zoo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class geAllDiscountAmountQueryController implements Initializable {
	@FXML
	private Button backbtn;
	@FXML
	private ListView<String> resultList;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Image img = new Image("imgs/back.png", 66, 25, true, false);
		backbtn.setGraphic(new ImageView(img));
		TreeMap<Visitor, Double> map = Zoo.getInstance().geAllDiscountAmount();//call the getall discount amount from zoo save it into tree map
		if (map.isEmpty()) {//make sure it's not empty
			Alerts.alertBox(AlertType.INFORMATION, "Get All Discount Amount", "No results found!", "");
		}
		for (Visitor i : map.keySet()) {//print the Treemap
			if (i != null) {
				String result = i.toString() + " " + map.get(i);
				resultList.getItems().add(result);
			}
		}

	}

	public void back(ActionEvent event) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("Queries.fxml"));
			root.setStyle("-fx-background-image: url('imgs/zooEmployees.jpg');" + "-fx-background-size:cover");
			Scene scene = new Scene(root);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		} catch (IOException e) {
			Alerts.alertBox(AlertType.ERROR, "Back", "Could not go back!", "");
		}
	}

}
