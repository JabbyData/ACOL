package org.example.stocksimulationfx;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    @FXML
    private TextField quantityAvailable;
    @FXML
    private TextField nbPositions;

    public void setDate(){
        String new_date = String.valueOf(market.getDate());
        date.setText("Jour " + new_date);
    }

    @FXML
    private void nextDay(){
        boolean finished = market.nextDay();
        if (finished) {
            Stage stage = (Stage) date.getScene().getWindow();
            stage.close();
        }
        else {
            setDate();
        }
    }

    @FXML
    public void displayCurve(){
        String stockName = stocks.getValue();
        Image new_image = new Image("file:src/main/resources/Images/" + stockName + ".jpg"); //TODO : update in png
        curve.setImage(new_image);
        int quantity = market.getStock(stockName).getQuantity();
        quantityAvailable.setText(String.valueOf(quantity));
    }

    @FXML
    public void buyStock(){
        String stockName = stocks.getValue();
        Stock stock = market.getStock(stockName);
        Position position = user.getPortfolio().getPosition(stock, market.getDate());
        int quantityAvailableValue = stock.getQuantity();
        int quantity = Integer.parseInt(nbPositions.getText());
        if (quantityAvailableValue <= 0 || quantity > quantityAvailableValue){
            AlertBox.display("Erreur", "Pas assez de stock disponible, veuillez réitérer votre requête.");
        }
        else {
            float price = stock.getCurrentPrice(market.getDate());
            float cash = user.getPortfolio().getCash();
            if (cash < price) {
                AlertBox.display("Erreur", "Votre crédit est trop bas");
            }
            else {
                user.getPortfolio().addCash(-price*quantity);
                position.addQuantity(quantity,market.getDate());
                stock.setQuantity(quantityAvailableValue - quantity);
                quantityAvailable.setText(String.valueOf(stock.getQuantity()));
            }
        }
    }

    @FXML
    public void sellStock(){
        int date = market.getDate();
        String stockName = stocks.getValue();
        Stock stock = market.getStock(stockName);
        int quantityAvailableValue = stock.getQuantity();
        Position position = user.getPortfolio().getPosition(stock, market.getDate());
        int quantity = Integer.parseInt(nbPositions.getText());
        float price = stock.getCurrentPrice(date);
        user.getPortfolio().addCash(price*quantity);
        position.addQuantity(-quantity, market.getDate());
        stock.setQuantity(quantityAvailableValue + quantity);
        quantityAvailable.setText(String.valueOf(stock.getQuantity()));
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
