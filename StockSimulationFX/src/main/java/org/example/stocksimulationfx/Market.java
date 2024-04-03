package org.example.stocksimulationfx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Market {
    private int date;
    private User user;
    private HashSet<Stock> stocks;
    private ArrayList<Transaction> transactions;

    /* constructor */
    public Market(User user, HashSet<Stock> stocks, ArrayList<Transaction> transactions) {
        this.date = 1; /* starts at day 1 */
        this.user = user;
        this.stocks = stocks;
        /* automatic fill of the stocks */
        Stock Apple = new Stock("Apple", new ArrayList<Float>(), 10);
        Apple.addPrice(100.0f);
        Apple.addPrice(101.0f);
        Apple.addPrice(102.0f);
        Stock Microsoft = new Stock("Microsoft", new ArrayList<Float>(), 10);
        Microsoft.addPrice(200.0f);
        Microsoft.addPrice(201.0f);
        Microsoft.addPrice(202.0f);
        stocks.add(Apple);
        stocks.add(Microsoft);
        this.transactions = transactions;
    }

    /* getter */
    public int getDate() {
        return date;
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
}
