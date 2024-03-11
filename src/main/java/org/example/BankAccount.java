package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class BankAccount {
    // Attributes
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private String accountType;
    private List<String> transactionHistory;


    // Constructor
    public BankAccount(String accountNumber, String accountHolderName, double balance, String accountType){
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.accountType = accountType;
        this.transactionHistory = new ArrayList<>();
        recordTransaction("Account Created. Initial Balance: Ksh" + balance);
    }

    // Getter
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }


    // A Method for depositing funds
    public void deposit(double amount){
        balance += amount;
        System.out.println("Deposit Successful. Current balance: " + balance);
    }

    // A Method for depositing withdrawing
    public void withdraw(double amount){
        if (amount <= balance){
            balance -= amount;
            System.out.println("Withdrawal of Ksh. " + amount + " Was Successful. Current balance: Ksh " + balance);
        } else {
            System.out.println("Insufficient Funds. Withdrawal Failed!");
        }
    }

    // A Method to transfer funds from one bank account to another
    public void transferFunds(BankAccount recipientBankAccount, double amountToTransfer){
        if (amountToTransfer <= balance){
            balance -= amountToTransfer;
            recipientBankAccount.deposit(amountToTransfer);

            // Record transaction for the sender
            recordTransaction("Transfer To Account "+ recipientBankAccount.getAccountNumber() + ": Ksh" + amountToTransfer);

            // Record transaction for the sender
            recipientBankAccount.recordTransaction("Transfer From Account " + accountNumber + ": Ksh" + amountToTransfer);

        } else {
            System.out.println("Insufficient Funds. Transfer Failed!!");
        }
    }

    // A method to record transactions
    public void recordTransaction(String description){
        String transaction = LocalDateTime.now() + ": " + description;
        transactionHistory.add(transaction);
    }
}
