
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// Encapsulation Customer class
class Customer {
    private String customerId; // Instance Variables
    private String name;
    private String address;
    private String phone;

    // Constructor
    public Customer(String customerId, String name, String address, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    // Getters and Setters
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // method Overrideing
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

// Account class
class Account {
    private String accountId;
    private String customerId;
    private double balance;
    private String accountType; // Saving, Current

    public Account(String accountId, String customerId, double balance, String accountType) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.balance = balance;
        this.accountType = accountType;
    }

    // Getters and Setters
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", balance=" + balance +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}

// Transaction class
class Transaction {
    private String transactionId;
    private String accountId;
    private double amount;
    private Date date;
    private String type; // deposit or withdraw

    public Transaction(String transactionId, String accountId, double amount, Date date, String type) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.amount = amount;
        this.date = date;
        this.type = type;
    }

    // Getters and Setters
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", type='" + type + '\'' +
                '}';
    }
}

// InsufficientFundsException class
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// TransactionLog class
class TransactionLog {
    private List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactionsForAccount(String accountId) {
        return transactions.stream()
                .filter(t -> t.getAccountId().equals(accountId))
                .collect(Collectors.toList());
    }

    public List<Transaction> getAllTransactions() {
        return transactions;
    }
}

// BankManagementSystem class
public class Bank {
    private static List<Customer> customers = new ArrayList<>();
    private static List<Account> accounts = new ArrayList<>();
    private static TransactionLog transactionLog = new TransactionLog();

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
            System.out.println("7. Check Balance");
            System.out.println("8. View Transactions");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

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
                        checkBalance(scanner);
                        break;
                    case 8:
                        viewTransactions(scanner);
                        break;
                    case 9:
                        System.out.println("Thank for using our application...");
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
        customers.add(new Customer(customerId, name, address, phone));
        System.out.println("Customer added successfully.");
    }

    private static void viewCustomers() {
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
        scanner.nextLine();

        System.out.println("Select Account Type:");
        System.out.println("1. Saving");
        System.out.println("2. Current");
        System.out.print("Enter your choice: ");
        int accountTypeChoice = scanner.nextInt();
        scanner.nextLine();

        String accountType;
        switch (accountTypeChoice) {
            case 1:
                accountType = "Saving";
                break;
            case 2:
                accountType = "Current";
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Saving account.");
                accountType = "Saving";
        }

        accounts.add(new Account(accountId, customerId, balance, accountType));
        System.out.println("Account added successfully.");
    }

    private static void viewAccounts() {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    private static void depositMoney(Scanner scanner) {
        System.out.print("Enter Account ID: ");
        String accountId = scanner.nextLine();
        System.out.print("Enter Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        for (Account account : accounts) {
            if (account.getAccountId().equals(accountId)) {
                account.setBalance(account.getBalance() + amount);
                transactionLog.addTransaction(
                        new Transaction(generateTransactionId(), accountId, amount, new Date(), "deposit"));
                System.out.println("Deposit successful. New balance: " + account.getBalance());
                return;
            }
        }
        System.out.println("Account not found.");
    }

    private static void withdrawMoney(Scanner scanner) throws InsufficientFundsException {
        System.out.print("Enter Account ID: ");
        String accountId = scanner.nextLine();
        System.out.print("Enter Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        for (Account account : accounts) {
            if (account.getAccountId().equals(accountId)) {
                if (account.getBalance() < amount) {
                    throw new InsufficientFundsException("Insufficient funds.");
                }
                account.setBalance(account.getBalance() - amount);
                transactionLog.addTransaction(
                        new Transaction(generateTransactionId(), accountId, amount, new Date(), "withdraw"));
                System.out.println("Withdrawal successful. New balance: " + account.getBalance());
                return;
            }
        }
        System.out.println("Account not found.");
    }

    private static void checkBalance(Scanner scanner) {
        System.out.print("Enter Account ID: ");
        String accountId = scanner.nextLine();
        for (Account account : accounts) {
            if (account.getAccountId().equals(accountId)) {
                System.out.println("Current Balance: " + account.getBalance());
                return;
            }
        }
        System.out.println("Account not found.");
    }

    private static void viewTransactions(Scanner scanner) {
        System.out.print("Enter Account ID: ");
        String accountId = scanner.nextLine();
        List<Transaction> transactions = transactionLog.getTransactionsForAccount(accountId);
        if (transactions.isEmpty()) {
            System.out.println("No transactions found for this account.");
        } else {
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    private static String generateTransactionId() {
        return "TXN" + System.currentTimeMillis();
    }
}
