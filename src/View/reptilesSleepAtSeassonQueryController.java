package View;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Model.Reptile;

import Model.Zoo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class reptilesSleepAtSeassonQueryController implements Initializable {
	@FXML
	private Button backbtn;
	@FXML
	private ListView<Reptile> resultList;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Image img = new Image("imgs/back.png", 66, 25, true, false);
		backbtn.setGraphic(new ImageView(img));
		ArrayList<Reptile> a = Zoo.getInstance().reptilesSleepAtSeasson();//create a reptile arraylist annd add all the sleeping reptile to it
		if(a.isEmpty() || a == null) {//make sure it's not empty
			Alerts.alertBox(AlertType.INFORMATION, "Reptiles sleep at season", "No results found!", "");
		}
		for(Reptile i : a) {
			if(i != null) {
				resultList.getItems().add(i);//add them
			}
		}
	}

	public void back(ActionEvent event) {

		try {

			Parent root = FXMLLoader.load(getClass().getResource("Queries.fxml"));
			root.setStyle("-fx-background-image: url('imgs/zooEmployees.jpg');" + "-fx-background-size:cover");
			Scene scene = new Scene(root, 600, 600);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		} catch (IOException e) {
			Alerts.alertBox(AlertType.ERROR, "Back", "Could not go back!", "");
		}

	}
}
