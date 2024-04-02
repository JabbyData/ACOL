package org.example.stocksimulationfx;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class AlertBox {
    public static void display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        Label label = new Label();
        label.setText(message);

        VBox layout = new VBox(10);
        Button button = new Button("Ok");
        button.setOnAction(e -> {
            window.close();
        });
        layout.getChildren().addAll(label, button);
        layout.setAlignment(javafx.geometry.Pos.CENTER);
        Scene scene = new Scene(layout, 450, 200);
        window.setScene(scene);
        window.showAndWait();
    }
}
