package business.services;

import business.entities.*;
import business.exceptions.UserException;
import business.persistence.CupcakeMapper;
import business.persistence.Database;
import business.persistence.OrderMapper;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CupcakeFacade {
    private final CupcakeMapper cupcakeMapper;
    private final OrderMapper orderMapper;

    public CupcakeFacade(Database database) {
        this.cupcakeMapper = new CupcakeMapper(database);
        this.orderMapper = new OrderMapper(database);
    }

    public List<Order> getAllOrders() throws UserException
    {
        return orderMapper.getAllOrders();
    }

    public List<Topping> getAllTopping() throws UserException {

        return cupcakeMapper.getAllTopping();
    }

    public int deleteOrderFromItem (int id) throws UserException{
        return cupcakeMapper.deleteOrderFromItem(id);
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
