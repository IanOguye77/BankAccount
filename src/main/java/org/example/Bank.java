package org.example;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    // Attributes
    private Map<String, BankAccount> accounts;
    private  String  loggedInUser;

    // Constructors
    public Bank(){
        accounts = new HashMap<>();
        loggedInUser = null;
    }

    // A method to log in the user
    public boolean login(String username, String password){
        // simulate a simple login authentication
        if ("admin".equals(username) && "password".equals(password)){
            loggedInUser = username;
            return true;
        } else  {
            return false;
        }
    }

    // A Method to log out the user
    public void logout(){
        loggedInUser = null;
    }

    // A Method to add an account
    public void addAccount(String accountNumber, String accountHolderName, double balance, String accountType){
        BankAccount account = new BankAccount(accountNumber, accountHolderName, balance, accountType);

        accounts.put(accountNumber, account);

        System.out.println("Account Created Successfully.");
    }

    // A method to get an account
    public BankAccount getAccount(String accountNumber){
        return  accounts.get(accountNumber);
    }
}
