package Application.Logic.Providers;

import Domain.SupplierRepository;

public class SupplierProvider {
    private SupplierRepository supplierRepository;
    public SupplierProvider(){
        this.supplierRepository = SupplierRepository.getSupplierRepository();
    }

}
