package dao.Custom.Impl;

import dao.Custom.ItemDAO;
import dao.Custom.OrderDAO;
import dao.SQLUtil;
import model.CustomerDTO;
import model.ItemDTO;
import model.OrderDTO;

import java.sql.*;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

//    @Override
//    public boolean add(OrderDTO dto) throws SQLException, ClassNotFoundException {
//        return SQLUtil.execute("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",dto.getOrderId(),dto.getOrderDate(),dto.getCustomerId());
//    }

//    @Override
//    public boolean update(OrderDTO dto) throws SQLException, ClassNotFoundException {
//        return false;
//    }

    @Override
    public boolean exist(String orderId) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("SELECT oid FROM `Orders` WHERE oid=?",orderId);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public OrderDTO search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

//    @Override
//    public OrderDTO search(String s) throws SQLException, ClassNotFoundException {
//        return null;
//    }













//    @Override
//    public String generateOID() throws SQLException, ClassNotFoundException {
////        Connection connection = DBConnection.getDbConnection().getConnection();
////        Statement stm = connection.createStatement();
////        ResultSet rst = stm.executeQuery("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
////        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
//
//        return SQLUtil.execute("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
//    }
//    @Override
//    public boolean existOrder(String orderId) throws SQLException, ClassNotFoundException {
////       Connection connection = DBConnection.getDbConnection().getConnection();
////        PreparedStatement stm = connection.prepareStatement("SELECT oid FROM `Orders` WHERE oid=?");
////        stm.setString(1, orderId);
////        return stm.executeQuery().next();
//
//        return SQLUtil.execute("SELECT oid FROM `Orders` WHERE oid=?",orderId);
//    }
//    @Override
//    public boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException {
////        Connection connection = DBConnection.getDbConnection().getConnection();
////        PreparedStatement stm = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
////        stm.setString(1, dto.getOrderId());
////        stm.setDate(2, Date.valueOf(dto.getOrderDate()));
////        stm.setString(3, dto.getCustomerId());
////        return stm.executeUpdate()>0;
//
//        return SQLUtil.execute("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",dto.getOrderId(),dto.getOrderDate(),dto.getCustomerId());
//    }
}
