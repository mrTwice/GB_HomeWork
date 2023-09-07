package Application.Models.Providers;

import Domain.CustomerRepository;

public class CustomerProvider {
    private CustomerRepository customerRepository;
    public CustomerProvider(){
        this.customerRepository = CustomerRepository.getCustomerRepository();
    }
}
