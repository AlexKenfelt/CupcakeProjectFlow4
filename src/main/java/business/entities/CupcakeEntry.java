package business.entities;

import java.sql.Timestamp;

public class CupcakeEntry {
    private int topping;
    private int bottom;
    private int order;
    private double price;
    private User user;
    private Timestamp created;

    public CupcakeEntry(int topping, int bottom, int order, double price, Timestamp created) {
        this.topping = topping;
        this.bottom = bottom;
        this.order = order;
        this.price = price;
        this.created = created;
        this.user = null;
    }

    public int getTopping() {
        return topping;
    }

    public void setTopping(int topping) {
        this.topping = topping;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }
}

