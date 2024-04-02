package org.example.stocksimulationfx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardPortfolioController {
    @FXML
    private TextField date;

    @FXML
    private TextField valuePortfolio;

    @FXML
    public void setDate(){
        String new_date = "balbla";
        this.date.setText(new_date);
    }

    @FXML
    public void handleQuit(){
        Stage stage = (Stage) date.getScene().getWindow();
        boolean answer = ConfirmQuitBox.display("Confirm Quit", "Are you sure you want to quit?");
        if (answer)
            stage.close();
    }

    @FXML
    public void handleDeconnexion() throws IOException {
        Stage stage = (Stage) date.getScene().getWindow();
        boolean answer = ConfirmQuitBox.display("Confirm Deconnexion", "Are you sure you want to deconnect?");
        if (answer) {
            stage.close();
            LoginApplication loginApplication = new LoginApplication();
            loginApplication.start(new Stage());
        }
    }

    @FXML
    public void handleAction() throws Exception {
        Stage stage = (Stage) date.getScene().getWindow();
        stage.close();
        DashBoardAction dashBoardAction = new DashBoardAction(new DashboardActionController());
        dashBoardAction.start(new Stage());
    }

    @FXML
    public void nextDay(){
        // TODO : implement next day + updates
        System.out.println("Next day");
    }

    @FXML
    public void displayPortfolio(){
        // TODO : implement display portfolio
    }
}
