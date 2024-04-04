package org.example.stocksimulationfx;
import java.util.ArrayList;
import java.util.HashSet;

public class Market {
    private final int date_max = 20; /* nb of days of fun */
    private int date;
    private User user;
    private HashSet<Stock> stocks;
    private ArrayList<Transaction> transactions;

    private GameStock gameStocks = new GameStock();

    /* constructor */
    public Market(User user) {
        this.date = 1; /* starts at day 1 */
        this.user = user;
        this.transactions = new ArrayList<Transaction>();
        /* creates stocks */
        gameStocks.createStocks();
        this.stocks = gameStocks.getStocks();
    }
    /* getter */
    public int getDate() {
        return date;
    }

    public int getDate_max() {
        return date_max;
    }

    public HashSet<Stock> getStocks() {
        return stocks;
    }

    public Stock getStock(String stockName) {
        for (Stock s: stocks) {
            if (s.getName().equals(stockName)) {
                return s;
            }
        }
        return null;
    }

    public boolean nextDay() {
        date += 1;
        if (date > date_max){
            float balance = user.getPortfolio().getBalance();
            if (balance > user.getPortfolio().getInitialCash()){
                AlertBox.display("Bravo", "Vous avez gagné " + String.valueOf(balance - user.getPortfolio().getInitialCash()) + " $");
            }
            else {
                AlertBox.display("Dommage", "Vous avez perdu " + String.valueOf(user.getPortfolio().getInitialCash() - balance) + " $");
            }
            return true;
        }
        return false;
    }
}
