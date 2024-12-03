
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionLog {
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
