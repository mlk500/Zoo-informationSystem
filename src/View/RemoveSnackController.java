package View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.Reptile;
import Model.Snack;
import Model.Zoo;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class RemoveSnackController implements Initializable {

    @FXML
    private ComboBox<Snack> snackList;

    @FXML
    private Button removeBtn;
    @FXML
	private Button backbtn;

    
    @FXML
    void removeSnack(ActionEvent event) {
   	 Snack s=snackList.getSelectionModel().getSelectedItem();
   	if(snackList.getSelectionModel().isEmpty()) {
			Alerts.alertBox(AlertType.ERROR,"Invalid","Invalid Input", "" );		
   	}
   	else if(!(Zoo.getInstance().removeSnack(s))) {
			Alerts.alertBox(AlertType.ERROR,"Failed","The remove method has failed", "" );		

   	}
   	else {
    	Zoo.getInstance().removeSnack(snackList.getSelectionModel().getSelectedItem());//we remove the Snack from our hashmap
   	Alerts.alertBox(AlertType.CONFIRMATION,"Success","The Snack has been removed succsessfully", "" );		
   }
    }
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {//this function occurs immediately when we open the gui window which means that the item that we removed from the hashmap in the lsat time will not appear here because it will be updated
    	snackList.getItems().clear();//first we want to clear out combo box and then we add all the items to it
        //we add all of our items back to the list
    	snackList.getItems().addAll(Zoo.getInstance().getSnacks().values());
    	Image img = new Image("imgs/back.png", 66, 25, true, false);
		backbtn.setGraphic(new ImageView(img));
    }
    public void back(ActionEvent event) {
		if (ControllScenes.getType().equals(Users.ADMIN)) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("Removes.fxml"));
				root.setStyle("-fx-background-image: url('imgs/safari3.jpg');" + "-fx-background-size:cover");
				Scene scene = new Scene(root);
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(scene);
				window.show();
			} catch (IOException e) {
				Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
			}
		} else {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("RemoveForEmp.fxml"));
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
}
