package Application.DataBaseInterfaces;

import Application.Logic.Primitives.Users.Supplier;

import java.util.List;

public interface ISupplierRepo {
    List<Supplier> getAllProviders();
    Supplier getProviderByID(int id);
}
