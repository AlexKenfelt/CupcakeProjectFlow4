package business.services;

import business.entities.Bottom;
import business.entities.Cart;
import business.entities.CartItem;
import business.entities.Topping;
import business.exceptions.UserException;
import business.persistence.CupcakeMapper;
import business.persistence.Database;

import java.util.List;

public class CupcakeFacade {
    CupcakeMapper cupcakeMapper;

    public CupcakeFacade(Database database) {
        this.cupcakeMapper=new CupcakeMapper(database);

    }

    public List<Topping> getAllTopping() throws UserException {

        return cupcakeMapper.getAllTopping();
    }

    public List<Bottom> getAllBottom() throws UserException {

        return cupcakeMapper.getAllBottoms();
    }

    public Bottom getBottomById(int id) throws UserException {
        Bottom bottom = null;
        for (Bottom b : getAllBottom()) {
            if (b.getId() == id) {
                return b;
            }
        }
        return bottom;
    }

    public Topping getToppingById(int id) throws UserException {
        Topping topping = null;
        for (Topping t : getAllTopping()) {
            if (t.getId() == id) {
                return t;
            }
        }
        return topping;
    }

    public double calcTotalPrice(Cart cart){
        double totalPrice = 0;
        //double price = quantity * (topping.getPrice() + bottom.getPrice());
        for (CartItem c:cart.getCartItemList()) {
            totalPrice += c.getPrice();
        }

    return totalPrice;
    }

}
