package main;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UserCreationController {

    @FXML
    private Label messageLabel;

    @FXML
    private TextField passwordField;

    @FXML
    private Button registerButton;

    @FXML
    private TextField usernameField;

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
            messageLabel.setText("Guest registered!");
        } catch (IOException e) {
            messageLabel.setText("Error saving Guest.");
        }
    }

    }
