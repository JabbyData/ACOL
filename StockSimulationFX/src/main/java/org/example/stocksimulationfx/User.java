package org.example.stocksimulationfx;

public class User {
    private String username;
    private String password;
    private Portfolio portfolio;

    /* constructor */
    public User(String username, String password, Portfolio portfolio) {
        this.username = username;
        this.password = password;
        this.portfolio = portfolio;
    }

    /* getter */
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
