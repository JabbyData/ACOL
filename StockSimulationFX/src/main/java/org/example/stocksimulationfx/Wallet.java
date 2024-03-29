package org.example.stocksimulationfx;

import java.util.ArrayList;

public class Wallet {
    private ArrayList<Position> positions;
    private float cash;

    public Wallet() {
        this.cash = 0;
        this.positions = new ArrayList<>();
    }

    public float getCash() {
        return cash;
    }

    //Retourne la valeur du portefeuille cash + actifs
    public float getEquity() {
        float valueOfPositions = 0;
        for (Position p : positions) {
            valueOfPositions += p.getValue();
        }
        return this.cash + valueOfPositions;
    }

    /***public boolean positionExists(String stockName) {
        for (Position p: positions) {
            if (p.getStock().getName().compareTo(stockName) == 0) {
                return true;
            }
        }
        return false;
    }***/

    public Position getPosition(Stock stock) {
        for (Position p: positions) {
            if (p.getStock().equals(stock)) {
                return p;
            }
        }

        Position pos = new Position(true, stock, 0);
        this.positions.add(pos);

        return pos;
    }

    public void addCash(float x) {
        this.cash += x;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "positions=" + positions +
                ", cash=" + cash +
                '}';
    }
}
