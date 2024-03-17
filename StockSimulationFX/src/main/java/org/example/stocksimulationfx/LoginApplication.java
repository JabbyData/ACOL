package org.example.stocksimulationfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class LoginApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("home-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
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