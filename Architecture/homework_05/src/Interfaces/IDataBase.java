package Interfaces;

import Models.Product;

import java.util.List;

public interface IDataBase {
    List<Product> getAllProducts();

    void addProduct(Product product);

    Product getProductById(int id);
}
