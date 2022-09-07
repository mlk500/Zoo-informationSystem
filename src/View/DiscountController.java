package View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.Visitor;
import Model.Zoo;
import Utils.Discount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class DiscountController implements Initializable {

    @FXML
    private ComboBox<Visitor> visitorList;

    @FXML
    private ComboBox<Discount> discountList;
    @FXML
	private Button backbtn;

    @FXML
    void applyDiscount(ActionEvent event) {
    	Discount d=discountList.getSelectionModel().getSelectedItem();
    	Visitor v=visitorList.getSelectionModel().getSelectedItem();
    	if(v==null||d==null) {
    		Alerts.alertBox(AlertType.INFORMATION, "Error", "Invalid Selection try again", "");

    	}
    	else if(d.getPercentage()*v.checkTicketPrice() > 0.25*v.checkTicketPrice()) {
    		Alerts.alertBox(AlertType.INFORMATION, "Error", "You reached the maximum discount percentage which is 25%", "");
    	}
    	else {
    		v.setDiscount(d);
    		Alerts.alertBox(AlertType.INFORMATION, "Success", "Discount has been applied successfully", "");

    	}
    	
    }
   

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
        visitorList.getItems().clear();
        visitorList.getItems().addAll(Zoo.getInstance().getVisitors().values());
        discountList.getItems().clear();
        discountList.getItems().addAll(Discount.values());
        
        Image img = new Image("imgs/back.png", 66, 25, true, false);
		backbtn.setGraphic(new ImageView(img));
        
	}
	
	public void back(ActionEvent event) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("VisitorActions.fxml"));
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
