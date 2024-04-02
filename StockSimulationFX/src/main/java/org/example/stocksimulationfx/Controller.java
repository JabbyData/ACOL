package org.example.stocksimulationfx;
import javafx.fxml.FXML;

import java.util.ArrayList;

public abstract class Controller {
    protected User user = new User("a","p");
    protected Market market = new Market(user, new ArrayList<Stock>(), new ArrayList<Transaction>());

    abstract void handleQuit();
}