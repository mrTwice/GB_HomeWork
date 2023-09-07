package Application.Logic.Primitives;

import Application.Logic.Primitives.Users.Customer;
import Application.Logic.Primitives.Users.Supplier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order{
    private Supplier supplier;
    private Customer customer;
    private List<Product> productsList = new ArrayList<>();
    private Date orderDate;
    private float totalSum;

    public Order(Supplier supplier, Customer customer, List<Product> productsList, Date orderDate) {
        this.supplier = supplier;
        this.customer = customer;
        this.productsList = productsList;
        this.orderDate = orderDate;
        for (Product product: productsList) {
            float prise = product.getCost();
            this.totalSum += prise;
        }
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public float getTotalSum() {
        return totalSum;
    }
}
