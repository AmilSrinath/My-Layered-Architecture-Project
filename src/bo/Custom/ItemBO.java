package bo.Custom;

import model.CustomerDTO;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO {
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException;

    public boolean addItem(ItemDTO dto) throws SQLException, ClassNotFoundException ;

    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException ;

    public boolean existItem(String id) throws SQLException, ClassNotFoundException;

    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException;

    public String generateNewItemID() throws SQLException, ClassNotFoundException;
}
