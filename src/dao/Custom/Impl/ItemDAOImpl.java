package dao.Custom.Impl;

import dao.Custom.ItemDAO;
import dao.SQLUtil;
import db.DBConnection;
import model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<ItemDTO> allItems = new ArrayList<>();
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        Statement stm = connection.createStatement();
//        ResultSet rst = stm.executeQuery("SELECT * FROM Item");
        ResultSet rst = SQLUtil.execute("SELECT * FROM Item");

        while (rst.next()) {
            allItems.add(new ItemDTO(rst.getString("code"), rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand")));
        }
        return allItems;
    }

    @Override
    public boolean add(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand());
    }

    @Override
    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand(),dto.getCode());
    }

    @Override
    public boolean exist(String code) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("SELECT code FROM Item WHERE code=?",code);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst = connection.createStatement().executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

    @Override
    public boolean delete(String code) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Item WHERE code=?",code);
    }

    @Override
    public ItemDTO search(String code) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item WHERE code=?");
        pstm.setString(1, code + "");
        ResultSet rst = pstm.executeQuery();
        rst.next();
        return new ItemDTO(code + "", rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
    }
//    @Override
//    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
//        ArrayList<ItemDTO> allItems = new ArrayList<>();
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        Statement stm = connection.createStatement();
//        ResultSet rst = stm.executeQuery("SELECT * FROM Item");
//        while (rst.next()) {
//            allItems.add(new ItemDTO(rst.getString("code"), rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand")));
//        }
//        return allItems;
//    }
//    @Override
//    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
////        Connection connection = DBConnection.getDbConnection().getConnection();
////        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE code=?");
////        pstm.setString(1, code);
////        return pstm.executeUpdate() > 0;
//
//        return SQLUtil.execute("DELETE FROM Item WHERE code=?",code);
//    }
//    @Override
//    public boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
////        Connection connection = DBConnection.getDbConnection().getConnection();
////        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)");
////        pstm.setString(1, dto.getCode());
////        pstm.setString(2, dto.getDescription());
////        pstm.setBigDecimal(3, dto.getUnitPrice());
////        pstm.setInt(4, dto.getQtyOnHand());
////        return pstm.executeUpdate() > 0;
//
//        return SQLUtil.execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand());
//    }
//    @Override
//    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
////        Connection connection = DBConnection.getDbConnection().getConnection();
////        PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
////        pstm.setString(1, dto.getDescription());
////        pstm.setBigDecimal(2, dto.getUnitPrice());
////        pstm.setInt(3, dto.getQtyOnHand());
////        pstm.setString(4, dto.getCode());
////        return pstm.executeUpdate() > 0;
//
//        return SQLUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand(),dto.getCode());
//    }
//    @Override
//    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
////        Connection connection = DBConnection.getDbConnection().getConnection();
////        PreparedStatement pstm = connection.prepareStatement("SELECT code FROM Item WHERE code=?");
////        pstm.setString(1, code);
////        return pstm.executeQuery().next();
//
//        return SQLUtil.execute("SELECT code FROM Item WHERE code=?",code);
//    }
//    @Override
//    public String generateNewCode() throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        ResultSet rst = connection.createStatement().executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
//        if (rst.next()) {
//            String id = rst.getString("code");
//            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
//            return String.format("I00-%03d", newItemId);
//        } else {
//            return "I00-001";
//        }
//    }
//    @Override
//    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item WHERE code=?");
//        pstm.setString(1, code + "");
//        ResultSet rst = pstm.executeQuery();
//        rst.next();
//        return new ItemDTO(code + "", rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
//    }


}
