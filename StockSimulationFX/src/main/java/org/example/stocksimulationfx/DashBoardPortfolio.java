package org.example.stocksimulationfx;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class DashBoardPortfolio extends DashBoard {
    @Override
    public void start(Stage stage) throws Exception {
        javafx.fxml.FXMLLoader fxmlLoader = new javafx.fxml.FXMLLoader(DashBoardPortfolio.class.getResource("dashboard-modePortefeuille.fxml"));
        Parent root = fxmlLoader.load();
        DashboardPortfolioController controller = fxmlLoader.getController();
        controller.setDate();
        controller.setCash();
        controller.setValue();
        Scene scene = new Scene(root, 600, 400);
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
