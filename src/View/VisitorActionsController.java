package View;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;


import Utils.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.stage.Stage;


public class VisitorActionsController implements Initializable {
	@FXML
	private Button ticketBtn;
	@FXML
	private Button purchaseBtn;
	@FXML
	private Button newVBtn,moveBtn,discount;


	/*
	 * @FXML private ListView<String> resultList;
	 */
	//in this class we do all of the visitor actions
	@FXML
	private Button backbtn;

	@Override

	public void initialize(URL arg0, ResourceBundle arg1) {
		Image img = new Image("imgs/back.png", 66, 25, true, false);
		backbtn.setGraphic(new ImageView(img));
	}

	
	public void get(ActionEvent event) {

		if (event.getSource().equals(purchaseBtn)) {//we check if the button that pressed is purchase snack

			try {

				Parent root = FXMLLoader.load(getClass().getResource("PurchaseSnack.fxml"));//change to purchase snack scene
				root.setStyle("-fx-background-image: url('imgs/visitors.jpg');" + "-fx-background-size:cover");
				Scene scene = new Scene(root);
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(scene);
				window.show();
			} catch (IOException e) {
				Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");

			}

		}
		else if(event.getSource().equals(newVBtn)) {
			try {

				Parent root = FXMLLoader.load(getClass().getResource("AddVisitor.fxml"));//add visitor
				root.setStyle("-fx-background-image: url('imgs/visitors.jpg');" + "-fx-background-size:cover");
				Scene scene = new Scene(root);
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(scene);
				window.show();
			} catch (IOException e) {
				Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");

			}
		}
		
		else if(event.getSource().equals(moveBtn)) {//move visitor
			try {
				Parent root = FXMLLoader.load(getClass().getResource("MoveVisitor.fxml"));
				root.setStyle("-fx-background-image: url('imgs/visitors.jpg');" + "-fx-background-size:cover");
				Scene scene = new Scene(root);
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(scene);
				window.show();
			}
				catch (IOException e) {
					Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
				}}
		else if(event.getSource().equals(discount)) {
				try {
					Parent root = FXMLLoader.load(getClass().getResource("Discount.fxml"));
					root.setStyle("-fx-background-image: url('imgs/discount.jpg');" + "-fx-background-size:cover");
					Scene scene = new Scene(root);
					Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
					window.setScene(scene);
					window.show();
				}
					catch (IOException e) {
						Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
					}}
		}
		
	
		

	public void back(ActionEvent event) {

		if (ControllScenes.getType().equals(Users.ADMIN)) {//check if it's admin or employee
			try {

				Parent root = FXMLLoader.load(getClass().getResource("AdminWindow.fxml"));
				root.setStyle("-fx-background-image: url('imgs/safari3.jpg');" + "-fx-background-size:cover");
				Scene scene = new Scene(root);
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(scene);
				window.show();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		else if (ControllScenes.getType().equals(Users.ZOO_EMPLOYEE)) {
			try {

				Parent root = FXMLLoader.load(getClass().getResource("ZooEmployeeWindow.fxml"));
				root.setStyle("-fx-background-image: url('imgs/empimg.jpg');" + "-fx-background-size:cover");
				Scene scene = new Scene(root);
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(scene);
				window.show();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
