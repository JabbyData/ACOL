package org.example.stocksimulationfx;
import java.util.ArrayList;

public class Market {
    private int date;
    private User user;
    private ArrayList<Stock> stocks;
    private ArrayList<Transaction> transactions;

    /* constructor */
    public Market(User user, ArrayList<Stock> stocks, ArrayList<Transaction> transactions) {
        this.date = 1; /* starts at day 1 */
        this.user = user;
        this.stocks = stocks;
        this.transactions = transactions;
    }

    /* getter */
    public int getDate() {
        return date;
    }

    public User getUser() {
        return user;
    }

    public ArrayList<Stock> getStocks() {
        return stocks;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
}
