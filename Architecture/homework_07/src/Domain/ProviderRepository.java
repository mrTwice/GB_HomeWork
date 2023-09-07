package Domain;

import Application.DataBaseInterfaces.IProviderRepo;
import Application.Models.Primitives.Provider;
import java.util.List;

public class ProviderRepository implements IProviderRepo {
    private static ProviderRepository providerRepository;
    private List<Provider> providers;

    private ProviderRepository(){
        providerRepository = getProviderRepository();
    }

    public static ProviderRepository getProviderRepository(){
        if(providerRepository == null)
            providerRepository = new ProviderRepository();
        return providerRepository;
    }
    @Override
    public List<Provider> getAllProviders(){
        return null;
    }
    public Provider getProviderByID(int id){
        return null;
    }
}
