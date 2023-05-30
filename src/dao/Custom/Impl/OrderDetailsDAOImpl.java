package dao.Custom.Impl;

import dao.Custom.OrderDetailsDAO;
import dao.SQLUtil;
import model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {
    @Override
    public boolean saveOrderDetails(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");
//        stm.setString(1, dto.getOid());
//        stm.setString(2, dto.getItemCode());
//        stm.setBigDecimal(3, dto.getUnitPrice());
//        stm.setInt(4, dto.getQty());
//        return stm.executeUpdate()>0;

        return SQLUtil.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",dto.getOid(),dto.getItemCode(),dto.getUnitPrice(),dto.getQty());
    }

    @Override
    public ArrayList<OrderDetailsDAO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(OrderDetailsDAO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(OrderDetailsDAO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public OrderDetailsDAO search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }
}
