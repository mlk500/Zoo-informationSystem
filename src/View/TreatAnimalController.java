package View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.Animal;
import Model.Bird;
import Model.Mammal;
import Model.Reptile;
import Model.Section;
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
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class TreatAnimalController implements Initializable {

    @FXML
    private ListView<Animal> animalList;
    @FXML
	private Button backbtn;

    @FXML
    void Treat(ActionEvent event) {//in this class we treat animals 
      if(animalList.getSelectionModel().isEmpty()) {//we make sure it's not empty
			Alerts.alertBox(AlertType.INFORMATION, "Error", "invalid input!", " ");
      }
      else if (animalList.getSelectionModel().getSelectedItem() instanceof Bird) {//we check if it's a bird mammal or reptile
    	  Bird b =(Bird) animalList.getSelectionModel().getSelectedItem();
    	  b.setCanFly(true);//after pressing the treat button treat the bird so it can fly
    	  Alerts.alertBox(AlertType.INFORMATION, "Success", "Bird treated successfully", " ");
      }
      else if (animalList.getSelectionModel().getSelectedItem() instanceof Mammal) {
    	  Mammal m =(Mammal) animalList.getSelectionModel().getSelectedItem();
    	  m.setMeatEater(true);//we treated  the mammal so it could eat meat
    	  Alerts.alertBox(AlertType.INFORMATION, "Success", "Mammal treated successfully", " ");
      }
      
      else if (animalList.getSelectionModel().getSelectedItem() instanceof Reptile) {
    	  Reptile r =(Reptile) animalList.getSelectionModel().getSelectedItem();
    	  r.setDangerous(false);//treat the reptile to not to be dangerous
    	  Alerts.alertBox(AlertType.INFORMATION, "Success", "Reptile treated successfully", " ");
      }
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Image img = new Image("imgs/back.png", 66, 25, true, false);
		backbtn.setGraphic(new ImageView(img));

		animalList.getItems().clear();//we add all of the animals to the list
		if(ControllScenes.getType().equals(Users.ADMIN)) {// but we check if the user is admin then we add all of the animals that need treatment from all of the sections
		for(Bird b: Zoo.getInstance().getBirds().values()) {// else if it's a employee then we show the animals that need treatment from his section
			if(b!=null&&b.isCanFly()==false) {
				animalList.getItems().add(b);
			}
		}
			for(Reptile r:Zoo.getInstance().getReptiles().values()) {
				if(r!=null&&r.isDangerous()==true) {
					animalList.getItems().add(r);
				}
			}
			for(Mammal m :Zoo.getInstance().getMammals().values()) {
				if(m!=null&&m.isMeatEater()==false) {
					animalList.getItems().add(m);

				}
				
			}
		}
       
		else {//if not an admin then add the animals only in section
			Section s=ControllScenes.getEmp().getSection();//get the section
			for(Bird b: s.getBirds()) {
				if(b!=null&&b.isCanFly()==false) {
					animalList.getItems().add(b);
				}
			}
				for(Reptile r:s.getReptiles()) {
					if(r!=null&&r.isDangerous()==true) {
						animalList.getItems().add(r);
					}
				}
				for(Mammal m :s.getMammals()) {
					if(m!=null&&m.isMeatEater()==false) {
						animalList.getItems().add(m);

					}
					
				}
			
		}
	}
	public void back(ActionEvent event) {

		if (ControllScenes.getType().equals(Users.ADMIN)) {// if it's an admin take us back to the admin window
			try {

				Parent root = FXMLLoader.load(getClass().getResource("AdminWindow.fxml"));
				root.setStyle("-fx-background-image: url('imgs/zooEmployees.jpg');" + "-fx-background-size:cover");
				Scene scene = new Scene(root);
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(scene);
				window.show();
			} catch (IOException e) {
				Alerts.alertBox(AlertType.ERROR, "File Loading", "Coud not load file!", " ");
			}

		}

		else if (ControllScenes.getType().equals(Users.ZOO_EMPLOYEE)) {//else take us back to the zoo employee window
			try {

				Parent root = FXMLLoader.load(getClass().getResource("ZooEmployeeWindow.fxml"));
				root.setStyle("-fx-background-image: url('imgs/empimg.jpg');" + "-fx-background-size:cover");
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
