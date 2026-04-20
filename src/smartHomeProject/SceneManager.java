package smartHomeProject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Node;

public class SceneManager {
	
	 public static void switchScene(ActionEvent event, String fxmlFile) {
	        try {
	            Parent root = FXMLLoader.load(SceneManager.class.getResource(fxmlFile));

	            Stage stage;

	            if (event != null) {
	                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	            } else {
	                stage = (Stage) Stage.getWindows().get(0);
	            }

	            stage.setScene(new Scene(root));
	            //stage.setMaximized(true);
	            stage.setFullScreen(true);
	    		stage.setFullScreenExitHint("");
	            stage.show();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
