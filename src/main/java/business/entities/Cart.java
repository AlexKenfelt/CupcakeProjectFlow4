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

    // remove item 


    public double getTotalPrice(){
        double sum = 0.0;
        for (CartItem cartItem : cartItemList) {
            sum=sum+cartItem.getPrice()* cartItem.getQuantity();

        }

        return sum;
    }

}
