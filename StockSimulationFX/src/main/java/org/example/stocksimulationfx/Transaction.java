package org.example.stocksimulationfx;

public class Transaction extends AbstractPosition {

    public Transaction(int quantity, Stock stock, int date) {
        super(stock, quantity, date);
    }
}
