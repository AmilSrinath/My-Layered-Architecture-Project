package dao;

import dao.Custom.ItemDAO;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T,ID> extends SuperDAO{
    public ArrayList<T> getAll() throws SQLException, ClassNotFoundException;

    public boolean add(T dto) throws SQLException, ClassNotFoundException;

    public boolean update(T dto) throws SQLException, ClassNotFoundException;

    public boolean exist(ID id) throws SQLException, ClassNotFoundException;

    public String generateNewID() throws SQLException, ClassNotFoundException;

    public boolean delete(ID id) throws SQLException, ClassNotFoundException;

    public T search(ID id) throws SQLException, ClassNotFoundException;
}
