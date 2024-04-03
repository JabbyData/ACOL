package org.example.stocksimulationfx;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Position extends AbstractPosition {
    public Position( Stock stock, int quantity, int date) {
        super(stock, quantity, date);
    }
    public void setQuantity(int quantity) {
        super.setQuantity(quantity);
    }

}
