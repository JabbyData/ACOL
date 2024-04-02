package org.example.stocksimulationfx;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import java.io.IOException;

public class DashBoardAction extends DashBoard {
    @Override
    public void start(Stage stage) throws Exception {
        javafx.fxml.FXMLLoader fxmlLoader = new javafx.fxml.FXMLLoader(DashBoardPortfolio.class.getResource("dashboard-modeAction.fxml"));
        Parent root = fxmlLoader.load();
        DashboardActionController controller = fxmlLoader.getController();
        controller.setDate();
        controller.setStocks();
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
