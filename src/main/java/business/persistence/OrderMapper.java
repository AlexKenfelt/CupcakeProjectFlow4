package business.persistence;

import business.entities.Cart;
import business.entities.CartItem;
import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    Database database;

    public OrderMapper(Database database) {
        this.database = database;
    }

    public void insertOrders(int fk_user_id, Timestamp order_time) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO orders(fk_user_id, order_time) VALUES (?,?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, fk_user_id);
                ps.setTimestamp(2, order_time);
                ps.executeUpdate();
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new UserException(ex.getMessage());
        }
    }

    public List<Order> getAllOrders() throws UserException {
        List<Order> orderList = new ArrayList<>();

        try (Connection connection = database.connect())
        {
            String sql = "SELECT * FROM orders";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    int order_id = rs.getInt("order_id");
                    int fk_user_id = rs.getInt("fk_user_id");
                    Timestamp order_time = rs.getTimestamp("order_time");
                    String order_status = rs.getString("order_status");
                    User user = new User(fk_user_id);
                    orderList.add(new Order(order_id, user, order_time, order_status ));

                }
                return orderList;
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

    public void createOrder(Cart cart, int userId) throws Exception {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO orders(fk_user_id) VALUES (?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, userId);
                ps.executeUpdate();

                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int orderId = ids.getInt(1);

                for(CartItem c: cart.getCartItemList()){
                    createOrderLine(c, orderId);
                }
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    private void createOrderLine(CartItem c, int orderId) throws Exception {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO order_details(fk_topping_id, fk_bottom_id, detail_qty, detail_price, fk_order_id) VALUES (?,?,?,?,?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, c.getTop().getId());
                ps.setInt(2,c.getBottom().getId());
                ps.setInt(3,c.getQuantity());
                ps.setDouble(4,c.getPrice());
                ps.setInt(5,orderId);
                ps.executeUpdate();
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new Exception(ex.getMessage());
        }
    }
}