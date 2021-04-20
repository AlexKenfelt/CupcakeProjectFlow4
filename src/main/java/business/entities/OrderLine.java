package business.entities;

import java.sql.Timestamp;

public class OrderLine {
    private int topping;
    private int bottom;
    private int orderId;
    private double price;
    private Timestamp created;

    public OrderLine(int topping, int bottom, int orderId, double price, Timestamp created) {
        this.topping = topping;
        this.bottom = bottom;
        this.orderId = orderId;
        this.price = price;
        this.created = created;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }
}

