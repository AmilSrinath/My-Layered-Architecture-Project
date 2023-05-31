package bo.Custom;

import bo.CustomerBOImpl;
import bo.ItemBOImpl;
import bo.PurchasOrderBOImpl;
import bo.SuperBO;

public class BOFactoy {
    private static BOFactoy boFactory;
    private BOFactoy(){
    }
    public static BOFactoy getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactoy() : boFactory;
    }

    public enum BOTypes{
        CUSTOMER,ITEM,PO
    }

    //Object creation logic for BO objects
    public SuperBO getBO(BOTypes types){
        switch (types){
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case PO:
                return new PurchasOrderBOImpl();
            default:
                return null;
        }
    }
}
