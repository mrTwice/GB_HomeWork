package Application.Models.Providers;

import Domain.ProviderRepository;

public class ProviderProvider {
    private ProviderRepository providerRepository;
    public ProviderProvider(){
        this.providerRepository = ProviderRepository.getProviderRepository();
    }

}
