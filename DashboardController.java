package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class DashboardController {

    @FXML
    private Label messageLabel;

    @FXML
    private Button userCreationButton;

    @FXML
    private Label welcomeLabel;
    
    @FXML
    public void initialize() {

        User user = Session.getCurrentUser();

        if (user != null) {
            welcomeLabel.setText("Welcome, " + user.getRole() + " " + user.getUsername());
        }
        
        userCreationButton.setVisible(Session.isAdmin());
    }

    @FXML
    void openUserCreation(ActionEvent event) {
    	
    	SceneManager.switchScene(event, "usercreation.fxml");

    }

}

