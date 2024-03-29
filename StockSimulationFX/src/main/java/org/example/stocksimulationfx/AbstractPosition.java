package org.example.stocksimulationfx;

public abstract class AbstractPosition {
    private boolean isBuy;
    private Stock stock;
    private int quantity;

    public AbstractPosition(boolean isBuy, Stock stock, int quantity) {
        this.isBuy = isBuy;
        this.stock = stock;
        this.quantity = quantity;
    }

    protected int getQuantity() {
        return quantity;
    }

    public Stock getStock() {
        return stock;
    }

    public float getValue() {
        float price = stock.getCurrentPrice();

        if (isBuy) {
            return this.quantity * price;
        }

        return - this.quantity * price;
    }

    public boolean getIsBuy() {
        return isBuy;
    }

    protected void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    protected void inversePosition() {
        this.isBuy = !this.isBuy;
    }

    public boolean sameDirection(AbstractPosition pos) {
        return isBuy == pos.getIsBuy();
    }

    @Override
    public String toString() {
        return "AbstractPosition{" +
                "isBuy=" + isBuy +
                ", stock=" + stock +
                ", quantity=" + quantity +
                '}';
    }
}
