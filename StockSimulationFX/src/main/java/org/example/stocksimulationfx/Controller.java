package org.example.stocksimulationfx;
import javafx.fxml.FXML;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public abstract class Controller {
    protected User user = new User("a","p");
    protected Market market = new Market(user, new HashSet<Stock>(), new ArrayList<Transaction>());

    abstract void handleQuit();
}