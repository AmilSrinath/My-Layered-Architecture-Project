package bo;

import bo.Custom.ItemBO;
import dao.Custom.Impl.ItemDAOImpl;
import dao.Custom.ItemDAO;
import model.CustomerDTO;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDTO=new ItemDAOImpl();

    @Override
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        return itemDTO.getAll();
    }

    @Override
    public boolean addItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDTO.add(dto);
    }

    @Override
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDTO.update(dto);
    }

    @Override
    public boolean existItem(String id) throws SQLException, ClassNotFoundException {
        return itemDTO.exist(id);
    }

    @Override
    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
        return itemDTO.delete(id);
    }

    @Override
    public String generateNewItemID() throws SQLException, ClassNotFoundException {
        return itemDTO.generateNewID();
    }
    /*public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        return itemDTO.getAll();
    }

    public boolean addCItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDTO.add(dto);
    }

    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDTO.update(dto);
    }

    public boolean deleteItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDTO.delete(dto.getId());
    }

    public boolean exitItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDTO.exist(dto.getId());
    }

    public String genarateNewID() throws SQLException, ClassNotFoundException {
        return itemDTO.generateNewID();
    }

    public ItemDTO searchItem(ItemDTO    dto) throws SQLException, ClassNotFoundException {
        return itemDTO.search(dto.getId());
    }*/
}
