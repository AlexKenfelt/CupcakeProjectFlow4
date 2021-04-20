package business.entities;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartItemList = new ArrayList<>();

    public void addCartItem(CartItem cartItem) {
        cartItemList.add(cartItem);
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }
}
