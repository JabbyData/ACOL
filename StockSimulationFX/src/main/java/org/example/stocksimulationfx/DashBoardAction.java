package org.example.stocksimulationfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DashBoardAction extends Application {

    private Stage dashboardWindow;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        dashboardWindow = stage;
        javafx.fxml.FXMLLoader fxmlLoader = new javafx.fxml.FXMLLoader(DashBoardAction.class.getResource("dashboard-modeAction.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
        stage.show();
    }
}
