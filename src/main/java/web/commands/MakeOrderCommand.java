package web.commands;

import business.entities.Cart;
import business.entities.CartItem;
import business.exceptions.UserException;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MakeOrderCommand extends CommandUnprotectedPage{
    private final OrderFacade orderFacade;

    public MakeOrderCommand(String pageToShow) {
        super(pageToShow);
        orderFacade = new OrderFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {


        Cart cart = (Cart) request.getSession().getAttribute("cart");
        int userId = Integer.parseInt(request.getParameter("userid"));

        try {
            orderFacade.create(cart, userId);
        } catch (Exception e) {
            e.printStackTrace();
        }



        return pageToShow;


    }
}
