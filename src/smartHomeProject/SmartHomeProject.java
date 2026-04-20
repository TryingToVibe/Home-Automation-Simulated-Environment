package smartHomeProject;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import userAuthentication.LoginController;


//this is the driver -----------------------
public class SmartHomeProject extends Application{ 

	@Override
	public void start(Stage stage) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("../userAuthentication/loginpage.fxml"));
		Scene scene = new Scene(loader.load());
		
		//MainMenuController controller = loader.getController(); ---------- look into this??????????
		LoginController controller = loader.getController();
		
		stage.setTitle("Smart Home System");
		stage.setScene(scene);
		//stage.setMaximized(true);
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("");
		//loads system data
		System.out.println("This is the Repackaged version");
		stage.show();

		


		//start up for smart home ––––––––––––––––––––––––––––––––––––––––––––––

		SmartHomeSystem system = SmartHomeSystem.getInstance();
		//controller.setSystem(system);
		
		//loads system
		system.loadCurrentSystemData();

		//starts the clock
		system.startSimulation();


	}

	public static void main(String[] args) {




		launch(args); // THIS starts JavaFX -----------

	} //end of main
	
	//saves the data when the system is shutdown
	@Override
	public void stop() {
	    SmartHomeSystem.getInstance().saveCurrentSystemData();
	}

} //end of class
