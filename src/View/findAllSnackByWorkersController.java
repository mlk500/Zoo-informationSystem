package View;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


import Model.Snack;
import Model.SnackBar;
import Model.Zoo;
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


public class findAllSnackByWorkersController implements Initializable{
	@FXML
	private ListView<SnackBar> list;
	@FXML
	private ListView<Snack> resultList;
	@FXML
	private Button getbtn;
	@FXML
	private Button backbtn;
	@FXML
	private Label lbl1;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
			
	    ObservableList<SnackBar> oblist = FXCollections.observableArrayList();
		oblist.addAll(Zoo.getInstance().getBars().values());
		list.setItems(oblist);
		lbl1.setWrapText(true);
		Image img = new Image("imgs/back.png",66,25,true,false);	
		backbtn.setGraphic(new ImageView(img));
		
		
	}
	
	public void get(ActionEvent event) {
		SnackBar sb = list.getSelectionModel().getSelectedItem();
		if(sb != null) {
			ArrayList<Snack> a = new ArrayList<>();
			
			ObservableList<Snack> oblist = FXCollections.observableArrayList();
			
			a = Zoo.getInstance().findAllSnackByWorker(sb);//save all of the sanck to arraylist
			
			for(Snack i : a) {
				if(i != null) {
					
					oblist.add(i);//add it to the observable list
				}
			}
			resultList.setItems(oblist);
	}
		else
			Alerts.alertBox(AlertType.WARNING, "No Selection detected", "You must select an item", " ");//error
	}
	
	public void back(ActionEvent event) {
		
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("Queries.fxml"));
			root.setStyle("-fx-background-image: url('imgs/zooEmployees.jpg');"+"-fx-background-size:cover");
			Scene scene = new Scene(root);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		} catch (IOException e) {
			Alerts.alertBox(AlertType.ERROR, "Back", "Could not go back!", "");
		}
		
	}
	
	

}
