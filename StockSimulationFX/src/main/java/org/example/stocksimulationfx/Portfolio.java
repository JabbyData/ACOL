package org.example.stocksimulationfx;
import java.util.ArrayList;

public class Portfolio {
    private ArrayList<Position> positions;
    private float cash;

    public Portfolio() {
        this.cash = 100000; /* initial capital */
        this.positions = new ArrayList<>();
    }

    public float getCash() {
        return cash;
    }

    public Position getPosition(Stock stock, int date) {
        for (Position p: positions) {
            if (p.getStock().equals(stock)) {
                return p;
            }
        }
        Position pos = new Position( stock, 0, date);
        this.positions.add(pos);
        return pos;
    }

    public void addCash(float x) {
        this.cash += x;
    }

    public ArrayList<Position> getPositions() {
        return positions;
    }
}
