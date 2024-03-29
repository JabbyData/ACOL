package org.example.stocksimulationfx;

public class Transaction extends AbstractPosition {
    private int date;

    public Transaction(int quantity, boolean isBuy, Stock stock, int date) {
        super(isBuy, stock, quantity);
        this.date = date;
    }

    public void execute(Wallet wallet) {
        Position position = wallet.getPosition(this.getStock());

        float transactionValue =  this.getQuantity() * this.getStock().getCurrentPrice();

        if (this.getIsBuy()) {
            if (wallet.getCash() < transactionValue) {
                //TODO afficher message d'erreur "Capital insuffisant
                return;
            }
            wallet.addCash(- transactionValue);
        } else {
            wallet.addCash(transactionValue);
            if (position.getQuantity() == 0) {
                position.inversePosition();
            }
        }

        if (this.sameDirection(position)) {
            position.setQuantity(position.getQuantity() + this.getQuantity());
        }
        else if (position.getQuantity() >= this.getQuantity()) {
            position.setQuantity(position.getQuantity() - this.getQuantity());
        } else {
            position.inversePosition();
            position.setQuantity(this.getQuantity() - position.getQuantity());
        }
    }

    //TODO ajouter la transaction à la liste des transactions sur le marché
}
