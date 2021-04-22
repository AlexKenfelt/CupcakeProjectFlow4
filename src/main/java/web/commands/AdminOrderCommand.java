package web.commands;

import business.exceptions.UserException;
import business.services.CupcakeFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminOrderCommand extends CommandProtectedPage{

    public AdminOrderCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return super.execute(request, response);
    }

     @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        String deleteId = request.getParameter("delete");
        String editId = request.getParameter("edit");
        String update = request.getParameter("update");

        if(deleteId != null) {

            int rowsAffected = CupcakeFacade.deleteOrderFromItem(Integer.parseInt(deleteId));
            if (rowsAffected > 0) {
                request.getServletContext().setAttribute("sportList", CupcakeFacade.getAllCupcake());
            } else {
                request.setAttribute("error", "Du kan ikke fjerne denne sportsgren, da den er valgt af andre brugere!!");
            }
        }
        else if(editId != null) {
            Sport sport = bmiFacade.getSportById(Integer.parseInt(editId));
            request.setAttribute("sportItem", sport);
                return "editsportspage";
            }
        else if (update != null) {
            //opdater sportsgren i databasen
String name = request.getParameter("name");
            String sportId = request.getParameter("sports_id");
            int rowsInserted = bmiFacade.updateSport(Integer.parseInt(sportId), name);
            if (rowsInserted == 1) {
                request.getServletContext().setAttribute("sportList", bmiFacade.getAllSports());
            }

            System.out.println("Nyt navn: " + name + " for id = " + sportId);

        }
        return pageToShow;
    }

}
