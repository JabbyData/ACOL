package org.example.stocksimulationfx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardActionController extends Controller {
    @FXML
    private TextField date;

    @FXML
    private TextField selecDate;

    public void setDate(){
        String new_date = String.valueOf(market.getDate());
        date.setText("Jour " + new_date);
    }

    @FXML
    public void displayCurve(){
        //TODO : display the curve of the selected stock
        System.out.println("displayCurve");
    }

    @FXML
    public void nextDay(){
        //TODO : go to the next day and update values
        System.out.println("nextDay");
    }

    @FXML
    public void buyStock(){
        //TODO : buy the selected stock
        System.out.println("buyStock");
    }

    @FXML
    public void sellStock(){
        //TODO : sell the selected stock
        System.out.println("sellStock");
    }

    @FXML
    public void selecPrice(){
        //TODO : select the price of the stock
        System.out.println("selecPrice");
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
        boolean answer = ConfirmQuitBox.display("Confirm Decconexion", "Are you sure you want to deconnect?");
        if (answer) {
            stage.close();
            LoginApplication loginApplication = new LoginApplication();
            loginApplication.start(new Stage());
        }
    }

    @FXML
    public void handlePortfolio() throws Exception {
        Stage stage = (Stage) date.getScene().getWindow();
        stage.close();
        DashBoardPortfolio dashBoardPortfolio = new DashBoardPortfolio();
        dashBoardPortfolio.start(new Stage());
    }
}
