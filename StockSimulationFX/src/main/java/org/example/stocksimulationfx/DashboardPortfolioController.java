package org.example.stocksimulationfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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

public class DashboardPortfolioController extends Controller {
    @FXML
    private TextField date;
    @FXML
    private TextField cash;
    @FXML
    private TextField value;
    @FXML
    private TableView<Position> table;
    @FXML
    private TableColumn<Position, String> stockColumn;
    @FXML
    private TableColumn<Position, Integer> quantityColumn;
    @FXML
    private TableColumn<Position, Float> valueColumn;
    @FXML
    private ImageView curve;
    @FXML
    private Button evolution;

    @FXML
    public void setDate(){
        String new_date = String.valueOf(market.getDate());
        date.setText("Jour " + new_date);
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
        DashBoardAction dashBoardAction = new DashBoardAction();
        dashBoardAction.start(new Stage());
    }

    @FXML
    public void DisplayCurve() throws IOException {
        int date = market.getDate();
        DrawPortfolio();
        Image new_image = new Image("file:src/main/resources/Images/Portfolio.png");
        curve.setImage(new_image);
    }

    private void DrawPortfolio() throws IOException {
        BufferedImage image = new BufferedImage(600, 400, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, 600, 400);
        g2d.setColor(Color.BLACK);
        g2d.drawLine(60, 350, 550, 350);
        g2d.drawLine(60, 50, 60, 350);
        g2d.drawString("Jour", 550, 365);
        g2d.drawString("Valeur", 10, 30);
        ArrayList<Float> valueHistory = user.getPortfolio().getValueHistory();
        int size = valueHistory.size();
        /* find the range of values */
        float min = 10000f;
        float max = 0f;
        Iterator it = valueHistory.iterator();
        while (it.hasNext()) {
            float value = (float) it.next();
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
            }
        }
        float range = max - min;
        /* fill y axis */
        for (int i = 0; i < 10; i++) {
            g2d.drawLine(60, 350 - 30 * i, 60, 350 - 30 * i);
            g2d.drawString(String.valueOf((int)(min + i * (max - min))), 15, 355 - 30 * i);
        }
        /* fill x axis */
        int nbDays = market.getDate();
        for (int i = 0; i < nbDays; i++) {
            g2d.drawLine(60 + 50 * (i+1), 350, 60 + 50 * (i+1), 355);
            g2d.drawString(String.valueOf(i+1), 60 + 50 * (i+1), 365);
        }

        /* draw the curve */
        g2d.setColor(Color.BLUE);
        for (int i = 1; i < size - 1; i++) {
            g2d.drawLine(60 + 50 * i, 350 - (int) (30 * (valueHistory.get(i) - min) / range), 60 + 50 * (i+1), 350 - (int) (30 * (valueHistory.get(i+1) - min) / range));
        }


        g2d.dispose();
        ImageIO.write(image, "png", new File("src/main/resources/Images/Portfolio.png"));
    }

    public void setCash() {
        cash.setText(user.getPortfolio().getCash() + " $");
    }

    public void setValue() {
        int date = market.getDate();
        float sum = user.getPortfolio().getCash();
        for (Position p: user.getPortfolio().getPositions()) {
            p.udpateValue(date);
            sum += p.getValue();
        }
        value.setText(sum + " $");
    }

    public void UpdateValue(){
        int date = market.getDate();
        float sum = user.getPortfolio().getCash();
        for (Position p: user.getPortfolio().getPositions()) {
            p.udpateValue(date);
            sum += p.getValue();
        }
        user.getPortfolio().getValueHistory().add(sum);
    }

    public void populateTable(){
        stockColumn.setCellValueFactory(new PropertyValueFactory<>("stockName"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        table.setItems(getPositions());
        table.getColumns().setAll(stockColumn, quantityColumn, valueColumn);
    }

    public ObservableList<Position> getPositions() {
        ObservableList<Position> positions = FXCollections.observableArrayList();
        for (Position p : user.getPortfolio().getPositions()) {
            positions.add(p);
        }
        return positions;
    }
    @FXML
    public void nextDay(ActionEvent actionEvent) throws IOException {
        boolean finished = market.nextDay();
        if (finished) {
            Stage stage = (Stage) date.getScene().getWindow();
            stage.close();
        }
        else {
            setDate();
            setCash();
            setValue();
            UpdateValue();
            populateTable();
            DisplayCurve();
        }
    }
}
