
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankOperations {
    private List<Customer> customers = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();
    private TransactionLog transactionLog = new TransactionLog();

    public void addCustomer(String customerId, String name, String address, String phone) {
        customers.add(new Customer(customerId, name, address, phone));
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addAccount(String accountId, String customerId, double balance) {
        // accounts.add(new Account(accountId, customerId, balance));
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void depositMoney(String accountId, double amount) {
        for (Account account : accounts) {
            if (account.getAccountId().equals(accountId)) {
                account.setBalance(account.getBalance() + amount);
                transactionLog.addTransaction(
                        new Transaction(generateTransactionId(), accountId, amount, new Date(), "deposit"));
                return;
            }
        }
    }

    public void withdrawMoney(String accountId, double amount) throws InsufficientFundsException {
        for (Account account : accounts) {
            if (account.getAccountId().equals(accountId)) {
                if (account.getBalance() < amount) {
                    throw new InsufficientFundsException("Insufficient funds.");
                }
                account.setBalance(account.getBalance() - amount);
                transactionLog.addTransaction(
                        new Transaction(generateTransactionId(), accountId, amount, new Date(), "withdraw"));
                return;
            }
        }
    }

    public List<Transaction> getTransactionsForAccount(String accountId) {
        return transactionLog.getTransactionsForAccount(accountId);
    }

    private String generateTransactionId() {
        return "TXN" + System.currentTimeMillis();
    }
}
