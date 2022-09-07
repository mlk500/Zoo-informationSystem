package View;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alerts {//we created an alert class to save an alert in it and each time we wanna create an alert we just call this alert class instead of declaring a new alert each time Alerts.AlertBox
	public static void alertBox(AlertType alertType, String title, String head,String content) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(head);
		alert.setContentText(content);
		alert.showAndWait();
	}
}
