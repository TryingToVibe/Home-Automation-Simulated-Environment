package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;

public class LoginController {
	
	@FXML
    private Button loginButton;

    @FXML
    private Label messageLabel;

    @FXML
    private TextField passwordField;

    @FXML
    private Button registerButton;

    @FXML
    private TextField usernameField;

    @FXML
    void handelLogin(ActionEvent event) {
    	
    	 String username = usernameField.getText();
         String password = passwordField.getText();

         try {
             User user = UserManager.authenticate(username, password);

             if (user != null) {
                 Session.login(user);
                 messageLabel.setText("Login successful!");
                 SceneManager.switchScene(event, "dashboard.fxml");
             } else {
                 messageLabel.setText("Invalid username or password.");
             }

         } catch (IOException e) {
             messageLabel.setText("Error reading user data.");
         }
     }
      

    @FXML
    void handelRegister(ActionEvent event) {
    	
    	 String username = usernameField.getText();
         String password = passwordField.getText();

         if (username.isEmpty() || password.isEmpty()) {
             messageLabel.setText("Please fill in all fields.");
             return;
         }

         try {
             UserManager.registerUser(username, password);
             messageLabel.setText("User registered!");
         } catch (IOException e) {
             messageLabel.setText("Error saving user.");
         }
     }

    }
