package web.commands;

import business.entities.Cart;
import business.entities.CartItem;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MakeOrderCommand extends CommandUnprotectedPage{
    public MakeOrderCommand(String pageToShow) {
        super(pageToShow);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {


        Cart cart = (Cart) request.getSession().getAttribute("cart");

        for(CartItem ci : cart.getCartItemList()){
            System.out.println(ci.toString());
            OrderLine ol = new OrderLine();
            //Kald til DB -> orderline
            //ci.toString();
        }

        //Kald til DB mht. Order id ->

        //Nå´r i har order id -> hent order og gem i session

        //Lav kvit side og vis order session


        return pageToShow;


    }
}
