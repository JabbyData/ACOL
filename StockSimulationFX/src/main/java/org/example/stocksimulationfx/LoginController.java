package org.example.stocksimulationfx;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LoginController extends Controller{
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
        if (username.equals(this.user.getUsername()) && password.equals(this.user.getPassword())) {
            Scene prevScene = usernameField.getScene();
            prevScene.getRoot().setOpacity(0.2);
            Stage loginStage = (Stage) usernameField.getScene().getWindow();
            LoginSuccess loginSuccess = new LoginSuccess();
            loginSuccess.display("Connexion réussie", "Bienvenue, " + username + "!",loginStage);

        } else {
            infoLabel.setText("Mauvais identifants");
            infoLabel.setVisible(true);
            PauseTransition visiblePause = new PauseTransition(Duration.seconds(3));
            visiblePause.setOnFinished(e -> infoLabel.setVisible(false));
            visiblePause.play();
        }
    }

    @FXML
    @Override
    void handleQuit(){
        Stage stage = (Stage) usernameField.getScene().getWindow();
        boolean answer = ConfirmQuitBox.display("Confirm Quit", "Etes-vous sûr de vouloir quitter?");
        if (answer)
            stage.close();
    }
}