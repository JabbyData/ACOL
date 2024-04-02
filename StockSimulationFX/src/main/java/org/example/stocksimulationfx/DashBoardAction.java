package org.example.stocksimulationfx;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DashBoardAction extends DashBoard {
    public DashBoardAction(DashboardActionController dashboardActionController) {
        this.controller = dashboardActionController;
        this.fxmlLoader = new javafx.fxml.FXMLLoader(DashBoardAction.class.getResource("dashboard-modeAction.fxml"));
    }
    public void setDate(){
        this.controller.setDate();
    }
    @Override
    public void start(Stage stage) throws Exception {
        setDate();
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
