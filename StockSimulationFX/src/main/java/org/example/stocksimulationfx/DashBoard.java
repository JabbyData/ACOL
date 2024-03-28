package org.example.stocksimulationfx;

import javafx.application.Application;
import javafx.stage.Stage;

abstract class DashBoard extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public abstract void start(Stage stage) throws Exception;
    }