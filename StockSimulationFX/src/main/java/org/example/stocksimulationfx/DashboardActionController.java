package org.example.stocksimulationfx;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
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

    public void setDate() {
        String new_date = String.valueOf(market.getDate());
        date.setText("Jour " + new_date);
    }

    @FXML
    private void nextDay() throws IOException {
        boolean finished = market.nextDay();
        if (finished) {
            Stage stage = (Stage) date.getScene().getWindow();
            stage.close();
        } else {
            setDate();
            int date = market.getDate();
            user.getPortfolio().updateValue(date);
            if (stocks.getValue() != null) {
                displayCurve();
            }
        }
    }

    @FXML
    public void displayCurve() throws IOException {
        String stockName = stocks.getValue();
        int date = market.getDate();
        DrawCurve(stockName, date);
        Image new_image = new Image("file:src/main/resources/Images/" + stockName + ".png");
        curve.setImage(new_image);
        int quantity = market.getStock(stockName).getQuantity();
        quantityAvailable.setText(String.valueOf(quantity));
    }

    private void DrawCurve(String stockName, int date) throws IOException {
        BufferedImage image = new BufferedImage(600, 400, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, 600, 400);
        g2d.setColor(Color.BLACK);
        g2d.drawLine(50, 350, 550, 350);
        g2d.drawLine(50, 50, 50, 350);
        g2d.drawString("Jour", 550, 365);
        g2d.drawString("Prix ($)", 10, 30);
        /* get min max of prices */
        float min = 10000f;
        float max = 0f;
        ArrayList<Float> prices = market.getStock(stockName).getPrices();
        Iterator it = prices.iterator();
        while (it.hasNext()) {
            float price = (float) it.next();
            if (price < min) {
                min = price;
            }
            if (price > max) {
                max = price;
            }
        }
        /* fill y axis */
        for (int i = 0; i < 10; i++) {
            g2d.drawLine(50, 350 - 30 * (i+1), 55, 350 - 30 * (i+1));
            g2d.drawString(String.valueOf(min + i * (max - min)), 5, 355 - 30 * (i+1));
        }
        /* fill x axis */
        int nbDays = market.getdateMax();
        for (int i = 0; i < nbDays; i++) {
            g2d.drawLine(50 + 25 * i, 350, 50 + 25 * i, 345);
            g2d.drawString(String.valueOf(i + 1), 50 + 25 * i, 365);
        }

        /* draw the first point */
        float firstPrice = market.getStock(stockName).getPrices().get(0);
        g2d.fillOval(50, 320 - (int) ((firstPrice - min) * 30 / (max - min)), 5, 5);
        for (int i = 1; i < date; i++) {
            float price = market.getStock(stockName).getPrices().get(i);
            g2d.fillOval(50 + 25 * i, 320 - (int) ((price - min) * 30 / (max - min)), 5, 5);
            float prevPrice = market.getStock(stockName).getPrices().get(i - 1);
            g2d.drawLine(50 + 25 * (i-1), 320 - (int) ((prevPrice - min) * 30 / (max - min)), 50 + 25 * i, 320 - (int) ((price - min) * 30 / (max - min)));
        }
        g2d.dispose();
        ImageIO.write(image, "png", new File("src/main/resources/Images/" + stockName + ".png"));
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
            if (cash < price * quantity) {
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
            int date = market.getDate();
            int selectedDate = Integer.parseInt(selecDate.getText());
            int n = market.getStocks().iterator().next().getPrices().size();
            if (selectedDate < 1 || selectedDate > date) {
                AlertBox.display("Erreur", "Veuillez entrer un jour valide (entre 1 et " + date + ")");
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
            AlertBox.display("Erreur", "Veuillez entrer un nombre valide (entre 1 et " + market.getDate() + ")");
        }
    }

    @FXML
    public void handleQuit(){
        Stage stage = (Stage) date.getScene().getWindow();
        boolean answer = ConfirmQuitBox.display("Confirm Quit", "Etes-vous sûr de vouloir quitter?");
        if (answer)
            stage.close();
    }

    @FXML
    public void handleDeconnexion() throws IOException {
        Stage stage = (Stage) date.getScene().getWindow();
        boolean answer = ConfirmQuitBox.display("Confirm Deconnexion", "Etes-vous sûr de vouloir vous déconnecter?");
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
        stocks.getItems().addAll("apple","microsoft","google","amazon","danone","spotify","lvmh","hermes","coca","AXA","orange","tesla");
    }
}
