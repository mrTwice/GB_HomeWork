package Application.DataBaseInterfaces;

import Application.Models.Primitives.Users.Customer;

import java.util.List;

public interface ICustomerRepo {
    List<Customer> getAllCustomers();
    Customer getCustomerByID(int id);
}
