package org.example;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Create the Scanner Object
        Scanner scanner = new Scanner(System.in);

        // create a bank object
        Bank cplBank = new Bank();

        // login logic loop
        boolean isLoggedIn = false;
        do {
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();

            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            isLoggedIn = cplBank.login(username, password);

            if (!isLoggedIn){
                System.out.println("Invalid Username or Password. Please Try Again!!");
            }
        } while (!isLoggedIn);

        // A variable to save the user choice from the menu
        int userChoice;

        do {
            System.out.println("=================================================================================");
            System.out.println("\t\t\t\t\t\tWelcome To CPL BANK");
            System.out.println("=================================================================================");
            System.out.println("\n1.Add Account");
            System.out.println("2.Deposit Funds");
            System.out.println("3.Withdraw Funds");
            System.out.println("4.Transfer Funds");
            System.out.println("5.View Transaction History");
            System.out.println("6.Log Out");
            System.out.print("Enter Your Choice: ");

            userChoice = scanner.nextInt();
            scanner.nextLine(); // Consumes the newline character

            switch (userChoice){
                case 1:
                    System.out.print("Enter Account Number: ");
                    String accountNumber = scanner.nextLine();

                    System.out.print("Enter Account Holder Name: ");
                    String accountHolderName = scanner.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double balance = scanner.nextDouble();
                    scanner.nextLine(); // consumes new line character

                    System.out.println("Enter The Account Type (e.g. Savings, Checking): ");
                    String accountType = scanner.nextLine();

                    cplBank.addAccount(accountNumber, accountHolderName, balance, accountType);
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextLine();

                    BankAccount account = cplBank.getAccount(accountNumber);

                    if (account != null){
                        System.out.print("Enter The Amount To Deposit: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("Account Not Found!!");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextLine();
                    account = cplBank.getAccount(accountNumber);

                    if (account != null){
                        System.out.print("Enter Amount You Wish To Withdraw: ");
                        double withdrawalAmount = scanner.nextDouble();
                        account.withdraw(withdrawalAmount);
                    } else {
                        System.out.println("Account Not Found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Sender Account Number: ");
                    String senderAccountNumber = scanner.nextLine();

                    System.out.print("Enter Recipient Account Number: ");
                    String recipientAccountNumber = scanner.nextLine();

                    BankAccount senderAccount = cplBank.getAccount(senderAccountNumber);

                    BankAccount recipientAccount = cplBank.getAccount(recipientAccountNumber);

                    if (senderAccount != null && recipientAccount != null){
                        System.out.print("Enter Transfer Amount: ");
                        double transferAmount  = scanner.nextDouble();
                        senderAccount.transferFunds(recipientAccount, transferAmount);
                    } else {
                        System.out.println("Sender or Recipient Account Not Found!");
                    }
                    break;
                case 5:
                    System.out.print("Enter The Account Number: ");
                    accountNumber = scanner.nextLine();
                    account = cplBank.getAccount(accountNumber);
                    if (account != null){
                        System.out.println("Transaction History For Account: " + accountNumber);

                        List<String> transactions = account.getTransactionHistory();

                        for (String transaction : transactions){
                            System.out.println(transaction);
                        }
                    } else {
                        System.out.println("Account Not Found!!!");
                    }
                    break;
                case 6:
                    cplBank.logout();
                    System.out.println("Logged Out Successfully.");
                    break;
                default:
                    System.out.println("Invalid Choice. Please Enter Choice Between 1 and 5.");
            }

        } while (userChoice != 6);

        // close the scanner object
        scanner.close();
    }
}