package business.entities;

public class CartItem {
   private int bottom;
   private int top;
    private int quantity;

    public CartItem(int bottom, int top, int quantity) {
        this.bottom = bottom;
        this.top = top;
        this.quantity = quantity;
    }
}
