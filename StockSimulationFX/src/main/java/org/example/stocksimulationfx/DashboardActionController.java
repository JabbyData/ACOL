package org.example.stocksimulationfx;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DashboardActionController extends Controller {
    @FXML
    private ComboBox<String> stocks;
    @FXML
    private TextField date;
    @FXML
    private ImageView curve;
    @FXML
    private TextField selecDate;
    @FXML
    private TextField price;

    public void setDate(){
        String new_date = String.valueOf(market.getDate());
        date.setText("Jour " + new_date);
    }

    @FXML
    public void displayCurve(){
        Image new_image = new Image("file:src/main/resources/Images/" + stocks.getValue() + ".jpg"); //TODO : update in png
        curve.setImage(new_image);
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
        try {
            int selectedDate = Integer.parseInt(selecDate.getText());
            int n = market.getStocks().iterator().next().getPrices().size();
            if (selectedDate < 1 || selectedDate > n) {
                AlertBox.display("Error", "Please enter a valid day (between 1 and " + String.valueOf(n) + ")");
            }
            else {
                String stock = stocks.getValue();
                Iterator<Stock> it = market.getStocks().iterator();
                while (it.hasNext()) {
                    Stock s = it.next();
                    if (s.getName().equals(stock)) {
                        ArrayList<Float> prices = s.getPrices();
                        float p = prices.get(selectedDate - 1);
                        price.setText(String.valueOf(p) + " $");
                    }
                }
            }
        }
        catch (NumberFormatException e){
            AlertBox.display("Error", "Please enter a valid day (between 1 and 20)");
        }
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
    public void handlePortfolio() throws Exception {
        Stage stage = (Stage) date.getScene().getWindow();
        stage.close();
        DashBoardPortfolio dashBoardPortfolio = new DashBoardPortfolio();
        dashBoardPortfolio.start(new Stage());
    }

    public void setStocks() {
        stocks.getItems().addAll("Apple","Microsoft");
    }
}
