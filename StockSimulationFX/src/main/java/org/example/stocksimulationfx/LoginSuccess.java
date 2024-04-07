package org.example.stocksimulationfx;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class LoginSuccess {
    private static Stage window;
    public void display(String Title, String message, Stage loginStage) {
        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(Title);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Accès au tableau de bord");
        closeButton.setOnAction(e -> {
            try {
                goToDashboard(loginStage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        window.setOnCloseRequest(e -> {
                    e.consume();
            try {
                goToDashboard(loginStage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(javafx.geometry.Pos.CENTER);

        Scene scene = new Scene(layout, 450, 200);
        window.setScene(scene);
        window.showAndWait();
    }

    public void goToDashboard(Stage loginStage) throws Exception {
        loginStage.close();
        window.close();
        DashBoardAction dashBoardAction = new DashBoardAction();
        dashBoardAction.start(new Stage());
    }
}
