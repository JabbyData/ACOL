package org.example.stocksimulationfx;

public abstract class AbstractPosition {
    protected Stock stock;
    protected int quantity;

    public AbstractPosition(Stock stock, int quantity) {
        this.stock = stock;
        this.quantity = quantity;
    }

    protected int getQuantity() {
        return quantity;
    }

    public Stock getStock() {
        return stock;
    }

    public float getValue(int date) {
        float price = stock.getCurrentPrice(date);
        return price * quantity;
    }

    protected void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addQuantity(int i) {
        this.quantity += i;
    }
}
