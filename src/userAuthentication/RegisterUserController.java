package userAuthentication;

import java.io.IOException;

import javafx.animation.Animation;
import javafx.animation.FillTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import smartHomeProject.SceneManager;

public class RegisterUserController {

    @FXML
    private Label messageLabel;

    @FXML
    private TextField passwordField;

    @FXML
    private Button registerButton;
    
    @FXML
    private Button exitButton;

    @FXML
    private TextField usernameField;
    
    @FXML
    private StackPane rootPane;

    @FXML
    private VBox registerCard;

    @FXML
    private Label titleLabel;

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
    
    public void initialize() {
    	DarkThemeUtil.applyDarkBackground(rootPane);
        DarkThemeUtil.styleCard(registerCard);
        DarkThemeUtil.styleTitle(titleLabel);
        DarkThemeUtil.styleMessageLabel(messageLabel);

        DarkThemeUtil.styleTextField(usernameField);
        DarkThemeUtil.styleTextField(passwordField);

        DarkThemeUtil.stylePrimaryButton(registerButton);
        DarkThemeUtil.styleSecondaryButton(exitButton);
    	
    	exitButton.setOnAction(e -> {
    		SceneManager.switchScene(e, "mainMenu.fxml");
    	});
    	
    }
   

    }