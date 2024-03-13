module org.example.stocksimulationfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.stocksimulationfx to javafx.fxml;
    exports org.example.stocksimulationfx;
}