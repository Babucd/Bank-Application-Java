// package bank;

import java.util.List;
import java.util.Scanner;

public class BankManagementSystem {
    private static BankOperations bankOperations = new BankOperations();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bank Management System");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Add Account");
            System.out.println("4. View Accounts");
            System.out.println("5. Deposit Money");
            System.out.println("6. Withdraw Money");
            System.out.println("7. View Transactions");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        addCustomer(scanner);
                        break;
                    case 2:
                        viewCustomers();
                        break;
                    case 3:
                        addAccount(scanner);
                        break;
                    case 4:
                        viewAccounts();
                        break;
                    case 5:
                        depositMoney(scanner);
                        break;
                    case 6:
                        withdrawMoney(scanner);
                        break;
                    case 7:
                        viewTransactions(scanner);
                        break;
                    case 8:
                        System.out.println("Thank you for using our application...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InsufficientFundsException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void addCustomer(Scanner scanner) {
        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();
        bankOperations.addCustomer(customerId, name, address, phone);
        System.out.println("Customer added successfully.");
    }

    private static void viewCustomers() {
        List<Customer> customers = bankOperations.getCustomers();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    private static void addAccount(Scanner scanner) {
        System.out.print("Enter Account ID: ");
        String accountId = scanner.nextLine();
        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = scanner.nextDouble();
        bankOperations.addAccount(accountId, customerId, balance);
        System.out.println("Account added successfully.");
    }

    private static void viewAccounts() {
        List<Account> accounts = bankOperations.getAccounts();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    private static void depositMoney(Scanner scanner) {
        System.out.print("Enter Account ID: ");
        String accountId = scanner.nextLine();
        System.out.print("Enter Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        bankOperations.depositMoney(accountId, amount);
        System.out.println("Deposit successful.");
    }

    private static void withdrawMoney(Scanner scanner) throws InsufficientFundsException {
        System.out.print("Enter Account ID: ");
        String accountId = scanner.nextLine();
        System.out.print("Enter Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        bankOperations.withdrawMoney(accountId, amount);
        System.out.println("Withdrawal successful.");
    }

    private static void viewTransactions(Scanner scanner) {
        System.out.print("Enter Account ID: ");
        String accountId = scanner.nextLine();
        List<Transaction> transactions = bankOperations.getTransactionsForAccount(accountId);
        if (transactions.isEmpty()) {
            System.out.println("No transactions found for this account.");
        } else {
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }
}
