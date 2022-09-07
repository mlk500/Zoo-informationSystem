package View;

import java.io.IOException;


import Model.Zoo;
import Model.ZooEmployee;
import Utils.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
//this class helps us to know if this is a employee or admin
public class ControllScenes {
	private static Users type;
	private static ZooEmployee employee;
	
	public static Users getType() {
		return type;
	}
	public static void setType(Users type) {
		ControllScenes.type = type;
	}
	public static void setZooEmployee(ZooEmployee emp) {
		if(type.equals(Users.ZOO_EMPLOYEE))
		   employee = emp;
		emp = null;
	}
	public static ZooEmployee getEmp() {//return the employee if want to get it
		return employee;
		
	
	}
	
	

}
