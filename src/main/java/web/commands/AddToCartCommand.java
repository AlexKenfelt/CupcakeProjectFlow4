package web.commands;

import business.entities.Bottom;
import business.entities.Cart;
import business.entities.CartItem;
import business.entities.Topping;
import business.exceptions.UserException;
import business.services.CupcakeFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddToCartCommand extends CommandUnprotectedPage {

    public AddToCartCommand(String pageToShow) {
        super(pageToShow);
    }

    CupcakeFacade cupcakeFacade = new CupcakeFacade(database);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart==null){
            cart = new Cart();
        }

        if(request.getParameter("topping") != null || request.getParameter("bottom") != null) {
            int toppingId = Integer.parseInt(request.getParameter("topping"));
            int bottomId = Integer.parseInt(request.getParameter("bottom"));
            Topping topping = cupcakeFacade.getToppingById(toppingId);
            Bottom bottom = cupcakeFacade.getBottomById(bottomId);
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            double price = quantity * (topping.getPrice() + bottom.getPrice());
            request.setAttribute("message", toppingId + bottomId + quantity + price);

            cart.addCartItem(new CartItem(bottom, topping, quantity, price));
        }
        //summen af alt i kurven - bregening
        request.setAttribute("total", cart.getTotalPrice());
        session.setAttribute("cart", cart);
        session.setAttribute("totalprice", cupcakeFacade.calcTotalPrice(cart));
        return pageToShow;
    }
}
