package business.entities;

import java.sql.Timestamp;

public class Order {
    private int orderId;
    private User user;
    private Timestamp timestamp;
    private String status;

    public Order(int orderId, User user, Timestamp timestamp, String status) {
        this.orderId = orderId;
        this.user = user;
        this.timestamp = timestamp;
        this.status = status;
    }

    public Order(int orderId, User user, Timestamp timestamp) {
        this.orderId = orderId;
        this.user = user;
        this.timestamp = timestamp;
        this.status = "afventer";
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", user=" + user.getEmail() +
                ", timestamp=" + timestamp +
                ", status='" + status + '\'' +
                '}';
    }
}
