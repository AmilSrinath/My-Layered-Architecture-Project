package dao.Custom;

import dao.CrudDAO;
import db.DBConnection;
import model.OrderDTO;
import model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface OrderDetailsDAO extends CrudDAO<OrderDetailsDAO,String> {
    public boolean saveOrderDetails(OrderDetailDTO dto) throws SQLException, ClassNotFoundException;
}
