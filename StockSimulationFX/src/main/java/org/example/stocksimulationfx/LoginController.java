package org.example.stocksimulationfx;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class LoginController {
    @FXML
    private Label infoLabel;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    void handleLogin(){
        String username = usernameField.getText();
        String password = passwordField.getText();
        if (username.equals("a") && password.equals("p")) {
            Scene prevScene = usernameField.getScene();
            prevScene.getRoot().setOpacity(0.2);
            Stage loginStage = (Stage) usernameField.getScene().getWindow();
            LoginSuccess loginSuccess = new LoginSuccess();
            loginSuccess.display("Login Successful", "Welcome, " + username + "!",loginStage);

        } else {
            infoLabel.setText("Invalid username or password.");
            infoLabel.setVisible(true);
            PauseTransition visiblePause = new PauseTransition(Duration.seconds(3));
            visiblePause.setOnFinished(e -> infoLabel.setVisible(false));
            visiblePause.play();
        }
    }

    @FXML
    void handleQuit(){
        Stage stage = (Stage) usernameField.getScene().getWindow();
        boolean answer = ConfirmQuitBox.display("Confirm Quit", "Are you sure you want to quit?");
        if (answer)
            stage.close();
    }
}