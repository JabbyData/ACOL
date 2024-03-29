package org.example.stocksimulationfx;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Stock {
    private String name;
    private ArrayList<Float> prices;

    public Stock(String name, ArrayList<Float> prices) {
        this.name = name;
        this.prices = prices;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Float> getPrices() {
        return prices;
    }

    public void setPrices(ArrayList<Float> prices) {
        this.prices = prices;
    }

    public void addPrice(float price) {
        prices.add(price);
    }

    public float getCurrentPrice() {
        if (prices.isEmpty()) {
            throw new NoSuchElementException("Prices list is empty");
        }
        return prices.get(prices.size() - 1);
    }

    @Override
    public String toString() {
        return "Stock{" +
                "name='" + name + '\'' +
                ", prices=" + prices +
                '}';
    }
}
