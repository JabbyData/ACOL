package org.example.stocksimulationfx;

public class User {
    private String username;
    private String password;

    private Portfolio Portfolio;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.Portfolio = new Portfolio();
    }

    /* getter */
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Portfolio getPortfolio() {
        return Portfolio;
    }
}
