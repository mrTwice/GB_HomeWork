package Application.DataBaseInterfaces;

import Application.Models.Primitives.Users.Supplier;

import java.util.List;

public interface IProviderRepo {
    List<Supplier> getAllProviders();
    Supplier getProviderByID(int id);
}
