
import java.util.Date;

public class Transaction {
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
