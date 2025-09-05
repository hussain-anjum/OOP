import java.util.Scanner;

class BankAccount {
    private static int accountCounter = 1000;
    private String accountNumber;
    private String name;
    private String address;
    private String accountType;
    private double balance;
    private int transactions;

    // Constructor
    public BankAccount(String name, String address, String accountType, double balance) {
        this.accountNumber = "BA" + accountCounter++;
        this.name = name;
        this.address = address;
        this.accountType = accountType;
        this.balance = balance;
        this.transactions = 0;
    }

    // Getter for account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Display information and balance of depositor
    public void displayInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: $" + balance);
        System.out.println("Number of Transactions: " + transactions);
        System.out.println("\n");
    }

    // Deposit amount in balance
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions++;
            System.out.println("Deposited $" + amount + " successfully.");
            System.out.println("\n");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw amount from balance
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions++;
            System.out.println("Withdrew $" + amount + " successfully.");
            System.out.println("\n");
        } else {
            System.out.println("Invalid or insufficient funds for withdrawal.");
        }
    }

    // Change address of depositor
    public void changeAddress(String newAddress) {
        this.address = newAddress;
        System.out.println("Address changed successfully.");
        System.out.println("\n");
    }

    // Get number of transactions
    public int getTransactions() {
        return transactions;
    }
}

public class BankApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of depositors: ");
        int numberOfDepositors = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        BankAccount[] accounts = new BankAccount[numberOfDepositors];

        // Enter information for each depositor
        for (int i = 0; i < numberOfDepositors; i++) {
            System.out.println("\nEnter details for depositor " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Address: ");
            String address = scanner.nextLine();
            System.out.print("Type of account: ");
            String accountType = scanner.nextLine();
            System.out.print("Initial balance: ");
            double balance = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            accounts[i] = new BankAccount(name, address, accountType, balance);
        }

        // Perform operations
        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Display information of a depositor");
            System.out.println("2. Deposit amount");
            System.out.println("3. Withdraw amount");
            System.out.println("4. Change address");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 5) break;

            System.out.print("Enter account number (e.g., BA1000): ");
            String accountNumber = scanner.nextLine();
            BankAccount account = null;
            System.out.println("\n");

            // Find the account
            for (BankAccount acc : accounts) {
                if (acc != null && acc.getAccountNumber().equals(accountNumber)) {
                    account = acc;
                    break;
                }
            }

            if (account == null) {
                System.out.println("Account not found.");
                continue;
            }

            switch (choice) {
                case 1:
                    account.displayInfo();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    account.displayInfo();
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    account.displayInfo();
                    break;
                case 4:
                    System.out.print("Enter new address: ");
                    String newAddress = scanner.nextLine();
                    account.changeAddress(newAddress);
                    account.displayInfo();
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }

        // Calculate total transactions
        int totalTransactions = 0;
        for (BankAccount account : accounts) {
            if (account != null) {
                totalTransactions += account.getTransactions();
            }
        }
        System.out.println("Total number of transactions: " + totalTransactions);

        scanner.close();
    }
}
