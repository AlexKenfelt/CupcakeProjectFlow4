package business.entities;

import java.sql.Timestamp;

public class AccountBalance {

    private int userId;
    private double balance;
    private Timestamp timestamp;

    public AccountBalance(int userId, double balance, Timestamp timestamp) {
        this.userId = userId;
        this.balance = balance;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "AccountBalance{" +
                "userId=" + userId +
                ", balance=" + balance +
                ", timestamp=" + timestamp +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
