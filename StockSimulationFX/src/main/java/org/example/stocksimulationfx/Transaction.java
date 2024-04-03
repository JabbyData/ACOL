package org.example.stocksimulationfx;

public class Transaction extends AbstractPosition {
    private int date;

    public Transaction(int quantity, Stock stock, int date) {
        super(stock, quantity, date);
        this.date = date;
    }
}
