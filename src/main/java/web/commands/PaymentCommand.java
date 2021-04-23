package web.commands;

import business.entities.Cart;
import business.entities.CartItem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PaymentCommand extends CommandProtectedPage{
    public PaymentCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {




        return pageToShow;
    }
}
