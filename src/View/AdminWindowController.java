package View;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import LaunchGui.Launching;
import Model.Bird;
import Model.Mammal;
import Model.Reptile;
import Model.Section;
import Model.Snack;
import Model.SnackBar;
import Model.Visitor;
import Model.Zoo;
import Model.ZooEmployee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/*
 * this is the admin window controller in here we have all of the buttons for thr admin add remove if he checks the revenue ...
 */

public class AdminWindowController implements Initializable{
	@FXML Button sectionInfobtn,visitorMethodsbtn,logoutBtn;
	public void addPressed(ActionEvent event)  {//if add is pressed then we go to the add screen
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Adds.fxml"));
			root.setStyle("-fx-background-image: url('imgs/safari3.jpg');" + "-fx-background-size:cover");
			Scene scene = new Scene(root);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
	}
		catch (IOException e) {
			Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
		}}

	public void removePressed(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Removes.fxml"));
			root.setStyle("-fx-background-image: url('imgs/safari3.jpg');" + "-fx-background-size:cover");
			Scene scene = new Scene(root);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		}
			catch (IOException e) {
				Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
			}}

	public void employeeIDPressed(ActionEvent event) throws Exception {
		try {
           
			Parent root = FXMLLoader.load(getClass().getResource("EmployeeID.fxml"));
			root.setStyle("-fx-background-image: url('imgs/safari3.jpg');" + "-fx-background-size:cover");
			Scene scene = new Scene(root);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		} catch (IOException e) {
			Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
		}
	}

	public void getPressed(ActionEvent event){
		try {
		
			Parent root = FXMLLoader.load(getClass().getResource("Gets.fxml"));
			Scene scene = new Scene(root);
			root.setStyle("-fx-background-image: url('imgs/empimg.jpg');" + "-fx-background-size:cover");
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		
		
			
			
		}
			catch (IOException e) {
				Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
			}}

	public void queriesPressed(ActionEvent event) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("Queries.fxml"));
			root.setStyle("-fx-background-image: url('imgs/safari3.jpg');" + "-fx-background-size:cover");
			Scene scene = new Scene(root);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		} catch (IOException e) {
			//Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
			e.printStackTrace();
		}
	}

	public void infoPressed(ActionEvent event){
		try {
            //no info
			Parent root = FXMLLoader.load(getClass().getResource("Data.fxml"));
			root.setStyle("-fx-background-image: url('imgs/sections.jpg');" + "-fx-background-size:cover");
			Scene scene = new Scene(root);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		} catch (IOException e) {
			Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
		}
	}
	

	public void revenuePressed(ActionEvent event) throws Exception {

		Alerts.alertBox(AlertType.INFORMATION, "Revenue", "", "Zoo Revenue: " + Zoo.getInstance().checkTotalRevenue());
	}


	public void visitorActionsPressed(ActionEvent event) throws Exception {
		try {
           
			Parent root = FXMLLoader.load(getClass().getResource("VisitorActions.fxml"));
			root.setStyle("-fx-background-image: url('imgs/safari3.jpg');" + "-fx-background-size:cover");
			Scene scene = new Scene(root);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		} catch (IOException e) {
			//Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
			e.printStackTrace();
		}
	}

	public void animalTreatPressed(ActionEvent event) throws Exception {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("TreatAnimal.fxml"));
			root.setStyle("-fx-background-image: url('imgs/vet.jpg');" + "-fx-background-size:cover");
			Scene scene = new Scene(root);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		} catch (IOException e) {
			 Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
			//e.printStackTrace();
		}
	}

	public void logout(ActionEvent event) {// we log out of the system be takeen back to the original screen log in and save all of the data
		
		Launching.save();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));

root.setStyle("-fx-background-image: url('imgs/ZooVid.gif');" + "-fx-background-size:50%");
			Scene empScene = new Scene(root);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(empScene);
			window.show();
			
		} catch (IOException e) {
			Alerts.alertBox(AlertType.ERROR, "Logout", "Coud not logout", " ");
		}
		
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Image img = new Image("imgs/log out.png", 64, 30, true, false);
		logoutBtn.setGraphic(new ImageView(img));
		
	}
}
