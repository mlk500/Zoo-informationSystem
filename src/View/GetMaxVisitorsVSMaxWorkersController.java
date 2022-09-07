
	package View;

	import java.io.IOException;
	import java.net.URL;
	
	import java.util.ResourceBundle;

	
import Model.Section;
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

	public class GetMaxVisitorsVSMaxWorkersController implements Initializable {
		@FXML
		private Button backbtn;
		@FXML
		private ListView<Section> resultList;

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			Image img = new Image("imgs/back.png", 66, 25, true, false);
			backbtn.setGraphic(new ImageView(img));
			Section s = Zoo.getInstance().getMaxVisitorsVSMaxWorkers();
			if(s == null) {//make sure it's not null
				Alerts.alertBox(AlertType.INFORMATION, "Max Visitors VS Max Workers", "No results found!", "");
			}
			resultList.getItems().add(s);//add the section to listview to display it
			
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
