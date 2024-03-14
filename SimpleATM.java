package project;

import java.util.Scanner;

public class SimpleATM {
    private static String atmPin;
    private static int count = 3;
    private static double balance = 1000; // Initial balance
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Simple ATM!");

        // Create PIN
        createPin();

        // Pin verification
        boolean pinVerified = verifyPin();
        if (!pinVerified) {
            System.out.println("Your card has been blocked!! \n"+"Contact your bank");
            return;
        }

        boolean running = true;
        while (running) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you !!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        }

        sc.close();
    }

    private static void createPin() {
        System.out.print("Create your ATM PIN: ");
        atmPin = sc.next();
    }

    private static boolean verifyPin() {
        while (count > 0) {
            System.out.print("Enter your ATM PIN: ");
            String inputPin = sc.next();
            if (inputPin.equals(atmPin)) {
                return true;
            } else {
                count--;
                if (count != 0) {
                    System.out.println("Incorrect PIN, Enter the valid PIN "+count+" attempts remaining.");
                }
            }
        }
        return false;
    }

    private static void deposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = sc.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid amount! Please enter a valid amount.");
        } else {
            balance += amount;
            System.out.println("Deposited successful.");
        }
    }

    private static void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = sc.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid amount! Please enter a valid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient Balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        }
    }

    private static void checkBalance() {
        System.out.println("Your current balance is: " + balance);
    }
}
SimpleATM.java
Displaying SimpleATM.java.
return 0;

