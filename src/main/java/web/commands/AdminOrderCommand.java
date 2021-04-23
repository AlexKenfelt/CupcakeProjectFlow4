package web.commands;

import business.entities.Order;
import business.exceptions.UserException;
import business.services.CupcakeFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminOrderCommand extends CommandProtectedPage{

    CupcakeFacade cupcakeFacade;

    public AdminOrderCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.cupcakeFacade = new CupcakeFacade(database);
    }

     @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String deleteId = request.getParameter("delete");

        try{
        if(deleteId != null) {
            int rowsAffected = cupcakeFacade.deleteOrderFromItem(Integer.parseInt(deleteId));
            if (rowsAffected > 0) {
                request.getServletContext().setAttribute("cupcakeList", cupcakeFacade.getAllOrders());
            } else {
                request.setAttribute("error", "Du kan ikke fjerne denne sportsgren, da den er valgt af andre brugere!!");
            }
        }
        } catch (UserException ex){
            ex.getMessage();
        }

        return pageToShow;
    }

}
