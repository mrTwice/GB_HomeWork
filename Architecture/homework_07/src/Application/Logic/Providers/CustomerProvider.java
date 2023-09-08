package Application.Logic.Providers;

import Domain.CustomerRepository;

import java.util.List;

public class CustomerProvider {
    private CustomerRepository customerRepository;
    public CustomerProvider(){
        this.customerRepository = CustomerRepository.getCustomerRepository();
    }

}
