package Domain;

import Application.DataBaseInterfaces.ISupplierRepo;
import Application.Logic.Primitives.Users.Supplier;
import java.util.List;

public class SupplierRepository implements ISupplierRepo {
    private static SupplierRepository supplierRepository;
    private List<Supplier> suppliers;

    private SupplierRepository(){
        supplierRepository = getSupplierRepository();
    }

    public static SupplierRepository getSupplierRepository(){
        if(supplierRepository == null)
            supplierRepository = new SupplierRepository();
        return supplierRepository;
    }
    @Override
    public List<Supplier> getAllProviders(){
        return null;
    }
    public Supplier getProviderByID(int id){
        return null;
    }
}
