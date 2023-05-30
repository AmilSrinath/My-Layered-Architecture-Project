package dao.Custom.Impl;

import dao.Custom.CustomerDAO;
import dao.Custom.ItemDAO;
import dao.SQLUtil;
import db.DBConnection;
import model.CustomerDTO;
import model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        Statement stm = connection.createStatement();
//        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer");

        while (rst.next()) {
            CustomerDTO customerDTO = new CustomerDTO(rst.getString("id"), rst.getString("name"), rst.getString("address"));
            allCustomers.add(customerDTO);
        }
        return allCustomers;
    }

    @Override
    public boolean add(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",dto.getId(),dto.getName());
    }

    @Override
    public boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?",dto.getName(),dto.getAddress(),dto.getId());
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("SELECT id FROM Customer WHERE id=?",s);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst = connection.createStatement().executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Customer WHERE id=?",s);
    }

    @Override
    public CustomerDTO search(String s) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Customer WHERE id=?");
        pstm.setString(1, s + "");
        ResultSet rst = pstm.executeQuery();
        rst.next();
        return new CustomerDTO(s + "", rst.getString("name"), rst.getString("address"));
    }


//    @Override
//    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
//        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        Statement stm = connection.createStatement();
//        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");
//
//        while (rst.next()) {
//            CustomerDTO customerDTO = new CustomerDTO(rst.getString("id"), rst.getString("name"), rst.getString("address"));
//            allCustomers.add(customerDTO);
//        }
//        return allCustomers;
//    }
//
//    @Override
//    public boolean addCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
////        Connection connection = DBConnection.getDbConnection().getConnection();
////        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer (id,name, address) VALUES (?,?,?)");
////        pstm.setString(1, dto.getId());
////        pstm.setString(2, dto.getName());
////        pstm.setString(3, dto.getAddress());
////        return pstm.executeUpdate() > 0;
//
//        return SQLUtil.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",dto.getId(),dto.getName());
//    }
//    @Override
//    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
////        Connection connection = DBConnection.getDbConnection().getConnection();
////        PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET name=?, address=? WHERE id=?");
////        pstm.setString(1, dto.getName());
////        pstm.setString(2, dto.getAddress());
////        pstm.setString(3, dto.getId());
////        return pstm.executeUpdate() > 0;
//
//        return SQLUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?",dto.getName(),dto.getAddress(),dto.getId());
//    }
//    @Override
//    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
////        Connection connection = DBConnection.getDbConnection().getConnection();
////        PreparedStatement pstm = connection.prepareStatement("SELECT id FROM Customer WHERE id=?");
////        pstm.setString(1, id);
////        return pstm.executeQuery().next();
//
//        return SQLUtil.execute("SELECT id FROM Customer WHERE id=?",id);
//    }
//    @Override
//    public String generateNewID() throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        ResultSet rst = connection.createStatement().executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
//        if (rst.next()) {
//            String id = rst.getString("id");
//            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
//            return String.format("C00-%03d", newCustomerId);
//        } else {
//            return "C00-001";
//        }
//    }
//
//    @Override
//    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
////        Connection connection = DBConnection.getDbConnection().getConnection();
////        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE id=?");
////        pstm.setString(1, id);
////        return pstm.executeUpdate() > 0;
//
//        return SQLUtil.execute("DELETE FROM Customer WHERE id=?",id);
//    }
//
//    @Override
//    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Customer WHERE id=?");
//        pstm.setString(1, id + "");
//        ResultSet rst = pstm.executeQuery();
//        rst.next();
//        return new CustomerDTO(id + "", rst.getString("name"), rst.getString("address"));
//    }


}
