package dao.Custom;

import dao.Custom.Impl.*;
import dao.SuperDAO;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){}
    public static DAOFactory getDaoFactory(){
        return (daoFactory == null) ? daoFactory =new DAOFactory() : daoFactory;
    }
    public enum DAOTypes{
        CUSTOMER,ITEM,ORDER,ORDER_DETAILS,QUERY_DAO
    }
    public SuperDAO getDAO(DAOTypes types){
        switch (types) {
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            case ORDER_DETAILS:
                return new OrderDetailsDAOImpl();
            case QUERY_DAO:
                return new QuaryDAOImpl();
            default:
                return null;
        }
    }
}
