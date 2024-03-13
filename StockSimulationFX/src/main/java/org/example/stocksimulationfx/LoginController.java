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
    void handleLogin() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        if (username.equals("a") && password.equals("p")) {
            Scene prevScene = usernameField.getScene();
            prevScene.getRoot().setOpacity(0.2);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("login-success.fxml"));
            Parent root = loader.load();

            LoginSuccessController loginSuccessController = loader.getController();
            loginSuccessController.setUsername("Welcome, " + username + "!");

            Stage successStage = new Stage();
            successStage.setScene(new Scene(root, 450, 200));
            successStage.show();
        } else {
            infoLabel.setText("Invalid username or password.");
            infoLabel.setVisible(true);
            PauseTransition visiblePause = new PauseTransition(Duration.seconds(3));
            visiblePause.setOnFinished(e -> infoLabel.setVisible(false));
            visiblePause.play();
        }
    }


}