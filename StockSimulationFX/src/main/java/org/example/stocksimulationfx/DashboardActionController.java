package org.example.stocksimulationfx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardActionController {
    @FXML
    private TextField Date;

    @FXML
    void handleQuit(){
        Stage stage = (Stage) Date.getScene().getWindow();
        boolean answer = ConfirmQuitBox.display("Confirm Quit", "Are you sure you want to quit?");
        if (answer)
            stage.close();
    }

    @FXML
    void handleDeconnexion() throws IOException {
        Stage stage = (Stage) Date.getScene().getWindow();
        boolean answer = ConfirmQuitBox.display("Confirm Decconexion", "Are you sure you want to deconnect?");
        if (answer) {
            stage.close();
            LoginApplication loginApplication = new LoginApplication();
            loginApplication.start(new Stage());
        }
    }
}
