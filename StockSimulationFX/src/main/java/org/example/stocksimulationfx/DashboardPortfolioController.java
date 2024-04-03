package org.example.stocksimulationfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

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
    public void nextDay(){
        // TODO : implement next day + updates
        System.out.println("Next day");
    }

    @FXML
    public void displayPortfolio(){
        // TODO : implement display portfolio
    }

    public void setCash() {
        cash.setText(user.getPortfolio().getCash() + " $");
    }

    public void setValue() {
        int date = market.getDate();
        float sum = user.getPortfolio().getCash();
        for (Position p: user.getPortfolio().getPositions()) {
            sum += p.getValue();
        }
        value.setText(sum + " $");
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
}
