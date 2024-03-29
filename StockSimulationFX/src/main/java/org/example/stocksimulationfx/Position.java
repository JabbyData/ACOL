package org.example.stocksimulationfx;

public class Position extends AbstractPosition {

    public Position(boolean isBuy, Stock stock, int quantity) {
        super(isBuy, stock, quantity);
    }

    public void setQuantity(int quantity) {
        super.setQuantity(quantity);
    }


}
