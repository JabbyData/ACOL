package org.example.stocksimulationfx;

import javafx.scene.Scene;
import javafx.stage.Stage;


public class DashBoardPortfolio extends DashBoard {
    @Override
    public void start(Stage stage) throws Exception {
        javafx.fxml.FXMLLoader fxmlLoader = new javafx.fxml.FXMLLoader(DashBoardPortfolio.class.getResource("dashboard-modePortefeuille.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setScene(scene);
        stage.setOnCloseRequest(e -> {
            e.consume();
            boolean answer = ConfirmQuitBox.display("Confirm Quit", "Are you sure you want to quit?");
            if (answer)
                stage.close();
        });
        stage.show();
    }
}
