package org.example.stocksimulationfx;

import java.util.ArrayList;
import java.util.HashSet;

public abstract class Controller {
    protected static User user = new User("a","p");
    protected static Market market = new Market(user);

    abstract void handleQuit();
}