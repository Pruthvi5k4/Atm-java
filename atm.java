import java.util.Scanner;

// Bank Account Class
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

// ATM Class
class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount account) {
        bankAccount = account;
    }

    public void displayOptions() {
        System.out.println("Options:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void performTransaction(int option) {
        Scanner scanner = new Scanner(System.in);

        switch (option) {
            case 1:
                System.out.print("Enter the amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                bankAccount.withdraw(withdrawAmount);
                break;

            case 2:
                System.out.print("Enter the amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                bankAccount.deposit(depositAmount);
                break;

            case 3:
                double balance = bankAccount.getBalance();
                System.out.println("Your account balance is: " + balance);
                break;

            case 4:
                System.out.println("Thank you for using the ATM!");
                break;

            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a Bank Account with initial balance of 1000
        BankAccount bankAccount = new BankAccount(1000);

        // Create ATM instance and link it to the Bank Account
        ATM atm = new ATM(bankAccount);

        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            // Display options and get user input
            atm.displayOptions();
            System.out.print("Enter your choice (1-4): ");
            option = scanner.nextInt();

            // Perform the selected transaction
            atm.performTransaction(option);

            System.out.println(); // Add a line for readability
        } while (option != 4);

        scanner.close();
    }
}