package org.example.stocksimulationfx;

public class Position extends AbstractPosition {

    public Position( Stock stock, int quantity) {
        super(stock, quantity);
    }

    public void setQuantity(int quantity) {
        super.setQuantity(quantity);
    }
}
