package bo;

import bo.Custom.CustomerBO;
import dao.Custom.CustomerDAO;
import dao.Custom.DAOFactory;
import dao.Custom.Impl.CustomerDAOImpl;
import model.CustomerDTO;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO=new CustomerDAOImpl();

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        return customerDAO.getAll();
    }

    @Override
    public boolean addCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.add(dto);
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.update(dto);
    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }

    @Override
    public String generateNewCustomerID() throws SQLException, ClassNotFoundException {
        return customerDAO.generateNewID();
    }
    /*public ArrayList<CustomerDTO> getAllCoustomer() throws SQLException, ClassNotFoundException {
        return customerDAO.getAll();
    }

    public boolean addCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.add(dto);
    }

    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.update(dto);
    }

    public boolean deleteCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(dto.getId());
    }

    public boolean exitCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(dto.getId());
    }

    public String genarateNewID() throws SQLException, ClassNotFoundException {
        return customerDAO.generateNewID();
    }

    public CustomerDTO searchCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.search(dto.getId());
    }*/
}
