package View;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import java.util.ResourceBundle;

import Model.Animal;

import Model.Zoo;
import Model.ZooEmployee;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
//in this class we call the animals by worker query from zoo class
public class AllAnimalsByWorkerQueryController implements Initializable {
	@FXML
	private ListView<ZooEmployee> list;
	@FXML
	private ListView<Animal> resultList;
	@FXML
	private Button getbtn;
	@FXML
	private Button backbtn;
	@FXML
	private Label lbl1;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {//initialize

		ObservableList<ZooEmployee> oblist = FXCollections.observableArrayList();
		oblist.addAll(Zoo.getInstance().getEmployees().values());
		list.setItems(oblist);
		lbl1.setWrapText(true);
		Image img = new Image("imgs/back.png", 66, 25, true, false);
		backbtn.setGraphic(new ImageView(img));

	}

	public void get(ActionEvent event) {//when the get button is pressed we check which zoo employee has been chosen create an arraylist and save all of the returned value in it
		ZooEmployee z = list.getSelectionModel().getSelectedItem();
		if (z != null) {
		ArrayList<Animal> a = Zoo.getInstance().allAnimalsByWorker(z);
		resultList.getItems().clear();
		if (a == null|| a.isEmpty()) {
			Alerts.alertBox(AlertType.ERROR, "Get All Animals By Worker", "No results found!", " ");
			return;
		}
		for (Animal i : a) {//and we add them to the resault list which we want to display
			if (i != null)
				resultList.getItems().add(i);
		}}
		else
			Alerts.alertBox(AlertType.INFORMATION, "All Animals By Worker", "No results found!", "");
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
			e.printStackTrace();
		}

	}

}
