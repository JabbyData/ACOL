package org.example.stocksimulationfx;

public abstract class AbstractPosition {
    protected Stock stock;
    protected String stockName;
    protected int quantity;

    protected float value;

    public AbstractPosition(Stock stock, int quantity, int date) {
        this.stock = stock;
        this.quantity = quantity;
        this.value = stock.getCurrentPrice(date)*quantity;
        this.stockName = stock.getName();
    }

    public Stock getStock() {
        return stock;
    }
    public int getQuantity() {
        return quantity;
    }
    public float getValue() {return value;
    }
    public String getStockName() {
        return stockName;
    }

    public void udpateValue(int date) {
        this.value = stock.getCurrentPrice(date)*quantity;
    }

    protected void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addQuantity(int i, int date) {
        this.quantity += i;
        this.value += i*stock.getCurrentPrice(date);
    }
}
