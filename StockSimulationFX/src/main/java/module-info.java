module org.example.stocksimulationfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens org.example.stocksimulationfx to javafx.fxml;
    exports org.example.stocksimulationfx;
}