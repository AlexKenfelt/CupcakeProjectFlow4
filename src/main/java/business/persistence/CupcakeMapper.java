package business.persistence;

import business.entities.Bottom;
import business.entities.Order;
import business.entities.Topping;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CupcakeMapper {

    private static Database database;

    public CupcakeMapper(Database database) {
        this.database = database;
    }

    public List<Order> getCupcakeDataByUserId() throws UserException
    {
        List<Order> cupcakeList = new ArrayList<>();

        try (Connection connection = database.connect())
        {
            String sql = "SELECT * FROM cupcake";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    int id = rs.getInt("id");
                    Timestamp timestamp = rs.getTimestamp("time");
                    String status = rs.getString("status");
                    int user_id = rs.getInt("user_id");

                    User user = new User(user_id);
                    cupcakeList.add(new Order(id, user, timestamp, status));
                }
                return cupcakeList;
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException("Connection to database could not be established");
        }
    }



    public List<Bottom> getAllBottoms() throws UserException {
        List<Bottom> bottomsList = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM bottom";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    double price = rs.getDouble("price");
                    Bottom tmpBottom = new Bottom(id, name, price);
                    bottomsList.add(tmpBottom);
                }
                return bottomsList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

    public List<Topping> getAllTopping() throws UserException {
        List<Topping> toppingList = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM topping";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    double price = rs.getDouble("price");
                    Topping tmpTopping = new Topping(id, name, price);
                    toppingList.add(tmpTopping);
                }
                return toppingList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }


    public static int deleteOrderFromItem(int id, Database database) throws UserException {
        try {
            Connection con = database.connect();
            String SQL = "DELETE from cupcake WHERE order_id = ?;";

            try (PreparedStatement ps = con.prepareStatement(SQL)) {
                ps.setInt(1, id);
                int rowAffected = ps.executeUpdate();
                return rowAffected;
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException(ex.getMessage());
        }
    }

}
