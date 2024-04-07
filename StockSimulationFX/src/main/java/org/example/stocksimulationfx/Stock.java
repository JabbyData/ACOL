package org.example.stocksimulationfx;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Stock {
    private String name;
    private ArrayList<Float> prices;

    private int quantity;

    public Stock(String name, ArrayList<Float> prices, int quantity) {
        this.name = name;
        this.prices = prices;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Float> getPrices() {
        return prices;
    }

    public float getCurrentPrice(int date) {
        if (prices.isEmpty()) {
            throw new NoSuchElementException("Prices list is empty");
        }
        return prices.get(date - 1);
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int i) {
        this.quantity = i;
    }
}
