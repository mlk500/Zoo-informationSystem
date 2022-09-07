package LaunchGui;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import Model.Bird;
import Model.Mammal;
import Model.Reptile;
import Model.Section;
import Model.Snack;
import Model.SnackBar;
import Model.Visitor;
import Model.Zoo;
import Model.ZooEmployee;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.fxml.FXMLLoader;
import View.*;


	public class Launching  extends Application {
		private static String[] arguments;
		private static String fileName = "zoo.ser";
		public static Stage stage;
		@Override
		public void start(Stage primaryStage) {
			stage = primaryStage;
			reading(arguments);
			try {
				Parent root = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
                root.setStyle("-fx-background-image: url('imgs/ZooVid.gif');" + "-fx-background-size:50%");
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
				stage.setScene(scene);
				stage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
	public static void save() {
			Zoo.getInstance().birdNum = Bird.getIdCounter();
			Zoo.getInstance().mammalNum = Mammal.getIdCounter();
			Zoo.getInstance().reptileNum = Reptile.getIdCounter();
			Zoo.getInstance().sectionNum = Section.getIdCounter();
			Zoo.getInstance().snackNum = Snack.getIdCounter();
			Zoo.getInstance().snackbarNum = SnackBar.getIdCounter();
			Zoo.getInstance().employeeNum = ZooEmployee.getIdCounter();
			Zoo.getInstance().visitorNum = Visitor.getIdCounter();
			

			try {
				FileOutputStream data = new FileOutputStream(fileName);
				ObjectOutputStream os = new ObjectOutputStream(data);
		         os.writeObject(Zoo.getInstance());
		         os.close();
		         data.close();
		         Alerts.alertBox(AlertType.INFORMATION, "Saved", "Saved to zoo.ser", "");
		    				
		      } catch (IOException i) {
		    	  Alerts.alertBox(AlertType.ERROR, "Failed to save","Failed to save to zoo.ser"," ");
		  
		      }
		}
		
		public static void reading(String[] args) {
			try {
				FileInputStream data = new FileInputStream(fileName);
				ObjectInputStream is = new ObjectInputStream(data);
				Zoo zoo = (Zoo) is.readObject();
				is.close();
				data.close();
				if(zoo == null) {
					System.out.println("No data found");
				}
				else {
				Zoo.setInstance(zoo);
	        	 Bird.setIdCounter(zoo.birdNum);
	        	 Mammal.setIdCounter(zoo.mammalNum);
	        	 Reptile.setIdCounter(zoo.reptileNum);
	        	 Visitor.setIdCounter(zoo.visitorNum);
	        	 ZooEmployee.setIdCounter(zoo.employeeNum);
	        	 Section.setIdCounter(zoo.sectionNum);
	        	 SnackBar.setIdCounter(zoo.snackbarNum);
	        	 Snack.setIdCounter(zoo.snackNum);
	        	 Alerts.alertBox(AlertType.INFORMATION, "Success in Reading", "Data was read from zoo.ser file"," ");
				return;
				}
			} catch (IOException e) {
				Alerts.alertBox(AlertType.ERROR, "Error in Reading", "Could not read from zoo.ser file", e.getLocalizedMessage());
			} catch (ClassNotFoundException e) {
				Alerts.alertBox(AlertType.ERROR, "Error in Reading", "Could not read from zoo.ser file", e.getLocalizedMessage());

				
			}
			try {
				Main.main(args);	
			}
			catch(Exception e) {
				Alerts.alertBox(AlertType.ERROR, "Error in Reading", "Could not read from input file", e.getLocalizedMessage());

			}
			
			
		}
		public static void main(String[] args) {
			arguments = args;
			launch(args);
		}
	}


