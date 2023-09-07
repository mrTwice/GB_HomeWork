package Application.DataBaseInterfaces;

import Application.Logic.Primitives.Users.Customer;

import java.util.List;

public interface ICustomerRepo {
    List<Customer> getAllCustomers();
    Customer getCustomerByID(int id);
}
