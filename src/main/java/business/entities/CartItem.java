package business.entities;

public class CartItem {
    private Bottom bottom;
    private Topping top;
    private int quantity;
    private double price;

    public CartItem(Bottom bottom, Topping top, int quantity, double price) {
        this.bottom = bottom;
        this.top = top;
        this.quantity = quantity;
        this.price = price;
    }

    public Bottom getBottom() {
        return bottom;
    }

    public Topping getTop() {
        return top;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
