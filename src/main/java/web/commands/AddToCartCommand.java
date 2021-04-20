package web.commands;

import business.entities.Cart;
import business.entities.CartItem;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddToCartCommand extends CommandUnprotectedPage {

    public AddToCartCommand(String pageToShow) {
        super(pageToShow);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart==null){
            cart = new Cart();

        }

        int toppingId = Integer.parseInt(request.getParameter("topping"));
        int bottomId = Integer.parseInt(request.getParameter("bottom"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        request.setAttribute("message",toppingId + bottomId + quantity);

        cart.addCartItem(new CartItem(bottomId, toppingId, quantity));
        session.setAttribute("cart", cart);

        return pageToShow;
    }
}
