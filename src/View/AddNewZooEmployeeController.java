package View;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Model.Section;
import Model.Visitor;
import Model.Zoo;
import Model.ZooEmployee;
import Utils.Discount;
import Utils.Gender;
import Utils.Job;
import Utils.TicketType;
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
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AddNewZooEmployeeController implements Initializable {

@FXML
private TextField empfname;

@FXML
private TextField emplname;

@FXML
private DatePicker empbday;

@FXML
private ComboBox<Section> empsec;

@FXML
private ComboBox<Job> empjob;

@FXML
private Button addbtn;

@FXML
private ComboBox<Gender> gender;
@FXML
private Button backbtn;

@FXML
void addEmployee(ActionEvent event) {
	ZooEmployee z=new ZooEmployee(empfname.getText(), emplname.getText(), empbday.getValue(),
			gender.getSelectionModel().getSelectedItem(), empsec.getSelectionModel().getSelectedItem(),
			empjob.getSelectionModel().getSelectedItem()); 
	if(empfname.getText().isEmpty()||emplname.getText().isEmpty()||empbday==null||empsec.getSelectionModel().isEmpty()||empjob.getSelectionModel().isEmpty()||gender.getSelectionModel().isEmpty())
	Alerts.alertBox(AlertType.INFORMATION, "Failed", "Invalid input", "Invalid input try again");
   else if(!(Zoo.getInstance().addEmployee(z))){
	Alerts.alertBox(AlertType.INFORMATION, "Failed", "Failed", "The add employee method has failed");}
   else
	   Alerts.alertBox(AlertType.INFORMATION, "Success", "Success", "The employee has been added successfully");
}

@Override
public void initialize(URL arg0, ResourceBundle arg1) {
gender.getItems().clear();
gender.getItems().addAll(Gender.values());
empsec.getItems().clear();
if(ControllScenes.getType().equals(Users.ADMIN))
 empsec.getItems().addAll(Zoo.getInstance().getSections().values());
else
empsec.getItems().add(ControllScenes.getEmp().getSection());
empjob.getItems().clear();
empjob.getItems().addAll(Job.values());
Image img = new Image("imgs/back.png", 66, 25, true, false);
backbtn.setGraphic(new ImageView(img));

empbday.setDayCellFactory(d -> new DateCell() {// in here we set the max date to be today which means that the
// user can't say an animal was born tommowrow
@Override
public void updateItem(LocalDate item, boolean empty) {
super.updateItem(item, empty);
setDisable(item.isAfter(LocalDate.now()));
}
});

}

public void back(ActionEvent event) {
if (ControllScenes.getType().equals(Users.ADMIN)) {
try {
Parent root = FXMLLoader.load(getClass().getResource("Adds.fxml"));
root.setStyle("-fx-background-image: url('imgs/safari3.jpg');" + "-fx-background-size:cover");
Scene scene = new Scene(root);
Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
window.setScene(scene);
window.show();
}

catch (IOException e) {
Alerts.alertBox(AlertType.ERROR, "Back", "Could not go back!", "");
}

} else {
try {
Parent root = FXMLLoader.load(getClass().getResource("AddForEmp.fxml"));
root.setStyle("-fx-background-image: url('imgs/safari3.jpg');" + "-fx-background-size:cover");
Scene scene = new Scene(root);
Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
window.setScene(scene);
window.show();
}

catch (IOException e) {
Alerts.alertBox(AlertType.ERROR, "Back", "Could not go back!", "");
}

}
}

}