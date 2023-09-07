package Application.Logic;

import Application.Logic.Primitives.Users.Staff;
import Application.Logic.Providers.*;

public class MainLogic {
    private OrderProvider orderProvider;
    private CustomerProvider customerProvider;
    private SupplierProvider providerRepository;
    private ProductProvider productRepository;
    private StaffProvider staffRepository;
    private Staff manager;

    public MainLogic() {
        this.orderProvider = new OrderProvider();
        this.customerProvider = new CustomerProvider();
        this.providerRepository = new SupplierProvider();
        this.productRepository = new ProductProvider();
        this.staffRepository = new StaffProvider();
    }


}
