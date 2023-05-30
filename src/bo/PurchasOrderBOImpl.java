package bo;

import bo.Custom.PlaceOrderBO;
import dao.Custom.*;
import dao.Custom.Impl.CustomerDAOImpl;
import dao.Custom.Impl.ItemDAOImpl;
import dao.Custom.Impl.OrderDAOImpl;
import dao.Custom.Impl.OrderDetailsDAOImpl;
import db.DBConnection;
import model.ItemDTO;
import model.OrderDTO;
import model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PurchasOrderBOImpl implements PlaceOrderBO {
    OrderDAO crudDAOOrd = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    ItemDAO crudDAOItem = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    public boolean purchasOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails){

        Connection connection = null;
        try {
            connection = DBConnection.getDbConnection().getConnection();

            //Check order id already exist or not
//            OrderDAO orderDAO = new OrderDAOImpl();
            boolean b1 = crudDAOOrd.exist(orderId);
            /*if order id already exist*/
            if (b1) {
                return false;
            }

            connection.setAutoCommit(false);

            //Save the Order to the order table
            boolean b2 = crudDAOOrd.add(new OrderDTO(orderId, orderDate, customerId));


            if (!b2) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }


            // add data to the Order Details table
            OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAOImpl();
            for (OrderDetailDTO detail : orderDetails) {
                boolean b3 = orderDetailsDAO.saveOrderDetails(detail);
                if (!b3) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }

                //Search & Update Item
                ItemDTO item = findItem(detail.getItemCode());
                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

                //update item
//                ItemDAO itemDAO = new ItemDAOImpl();
                boolean b = crudDAOItem.update(new ItemDTO(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand()));

                if (!b) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
            }

            connection.commit();
            connection.setAutoCommit(true);
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ItemDTO findItem(String code) {
        try {
//            ItemDAO itemDAO = new ItemDAOImpl();
            return crudDAOItem.search(code);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find the Item " + code, e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
