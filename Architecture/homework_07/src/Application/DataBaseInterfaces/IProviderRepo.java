package Application.DataBaseInterfaces;

import Application.Models.Primitives.Provider;

import java.util.List;

public interface IProviderRepo {
    List<Provider> getAllProviders();
    Provider getProviderByID(int id);
}
